package cn.teamhelper.library.util;


import cn.teamhelper.library.entity.LibraryContext;

import java.io.*;

public class FileUtils {
    public static void serialize(LibraryContext context, String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("文件存在");
        } else {
            boolean newFile = file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(context);
        oos.flush();
        fos.close();
        oos.close();
    }

    public static LibraryContext deserialize(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("文件存在");
        } else {
            file.createNewFile();
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            LibraryContext db = (LibraryContext) ois.readObject();
            ois.close();
            fis.close();
            return db;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
