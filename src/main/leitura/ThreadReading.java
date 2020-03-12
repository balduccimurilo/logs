package main.leitura;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;




public class ThreadReading implements Runnable {
	private Thread threadMonitor;
	private String dir;

	public static void main(String[] args) {
		new ThreadReading().init();
	}

	private void init() {
		setDir("./logArchive");
		this.threadMonitor = new Thread(this);
		this.threadMonitor.start();
	}

	private void verifyDirectory (String dir) throws IOException, SQLException, InterruptedException, ParseException {
		File diretorio = new File(dir);
		File arquivos[] = diretorio.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().toLowerCase().contains(".ejm");
			}
		});
		for (int i = 0; i < arquivos.length; i++) {
			File file = arquivos[i];
			newFile(file.getName());
			File diretorioDestino = new File("./RemovedArchives");
			boolean sucesso = file.renameTo(new File(diretorioDestino, file.getName()));
			if (sucesso) {
				System.out.println("Archive moved to '" + diretorioDestino.getAbsolutePath() + "'");
			} else {
				System.out.println("Error, tried to move '" + file.getAbsolutePath() + "' to '"
						+ diretorioDestino.getAbsolutePath() + "'");
			}
		}
	}

	public void newFile(String file) throws IOException, SQLException, InterruptedException, ParseException {
		new Leitura().ler(file);
	}

	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		while (this.threadMonitor == currentThread) {
			try {
				verifyDirectory(getDir());
			} catch (IOException e) {
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Reading Directory...");
		}
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
}