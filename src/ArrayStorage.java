import java.util.UUID;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null)
                storage[i] = null;
            else break;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {

                r.uuid = UUID.randomUUID().toString();
                storage[i] = r;
                return;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume r :
                storage) {
            if (r == null)
                return null;
            else if (r.toString().equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int ind = 0;
        int last = 0;
        int s = size();
        boolean found = false;
        for (int i = 0; i < s; i++) {
            if (storage[i].toString().equals(uuid)) {
                ind = i;
                found = true;
            }
        }

        if (found) {
            storage[ind] = storage[s - 1];
            storage[s - 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] res = new Resume[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = storage[i];
        }
        return res;
    }

    int size() {


        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null)
                return i;
        }
        return 0;
    }
}
