package com.movie.common.utils.movie;

import java.io.*;

public class CmdUtil {

	public static String execCmd(String cmd){
		BufferedReader bReader=null;
		InputStreamReader sReader=null;
		try
		{
//			String str = BaseConstant.FFMPEG_PATH+" "+cmd;
			String str = cmd;
			System.out.println (str);
			Process p = Runtime.getRuntime ().exec (str);//启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流
			//获取进程的标准输入流
			final InputStream is1 = p.getInputStream();
			//获取进城的错误流
			final InputStream is2 = p.getErrorStream();
			new Thread() {
				public void run() {
					BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
					try {
						String line1 = null;
						while ((line1 = br1.readLine()) != null) {
							if (line1 != null){}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					finally{
						try {
							is1.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();


				BufferedReader br2 = new  BufferedReader(new  InputStreamReader(is2));
				try {
					String line2 = null ;
					while ((line2 = br2.readLine()) !=  null ) {
						if (line2 != null){}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally{
					try {
						is2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			try
			{
				p.waitFor ();
				p.destroy();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace ();
			}
			return null;
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
		return null;
	}

	public static void writeTxtFile(String content, String filePath)
	{

		FileWriter fw = null;
		try
		{
			File file = new File(filePath);
			if (!file.exists())
			{
				file.createNewFile();
			}
			fw = new FileWriter(filePath);
			fw.write(content);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fw.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}

	}
}

