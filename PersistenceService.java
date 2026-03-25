import java.io.*;

public class PersistenceService {
    public static void saveState(String fileName, Object state) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(state);
            System.out.println("[SUCCESS] System state persisted to: " + fileName);
        } catch (IOException e) {
            System.err.println("[ERROR] Persistence failed: " + e.getMessage());
        }
    }

    public static Object loadState(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object state = ois.readObject();
            System.out.println("[SUCCESS] System state recovered from: " + fileName);
            return state;
        } catch (FileNotFoundException e) {
            System.out.println("[INFO] No persistence file found. Starting with fresh state.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[ERROR] Recovery failed: " + e.getMessage());
        }
        return null;
    }
}
