package classes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;public class WriterData {


    ParcerData parcerData;

    public WriterData(ParcerData parcerData) {
        this.parcerData = parcerData;
    }

    public void write() throws IOException {
        File file = new File(parcerData.getSurname() + ".txt");
        if (file.createNewFile()) {
            System.out.println(" файл создан в корневой директории проекта");
            try (FileWriter fw = new FileWriter(file, true)) {
                if (file.length() == 0) {
                    fw.write(parcerData.getFullName() + " " + parcerData.getDate() + " " + parcerData.getPhone() + " " + parcerData.getGender());
                } else {
                    fw.write("\n" + parcerData.getFullName() + " " + parcerData.getDate() + " " + parcerData.getPhone() + " " + parcerData.getGender());
                }
            } catch (IOException e) {
                throw new IOException("sddasda");
            } catch (OutOfMemoryError m) {
                throw new OutOfMemoryError("Не хватает памяти");
            }
        } else {
            System.out.println("Обновление файла " + file);
            try (FileWriter fw = new FileWriter(file, true)) {
                if (file.length() == 0) {
                    fw.write(parcerData.getFullName() + " " + parcerData.getDate() + " " + parcerData.getPhone() + " " + parcerData.getGender());
                } else {
                    fw.write("\n" + parcerData.getFullName() + " " + parcerData.getDate() + " " + parcerData.getPhone() + " " + parcerData.getGender());
                }
            } catch (IOException e) {
                throw new IOException("sddasda");
            } catch (OutOfMemoryError m) {
                throw new OutOfMemoryError("Не хватает памяти");
            }
        }

    }
}
