import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int ind = 0;
    void clear() {
        for (int i = 0; i < ind; i++) {
            storage[i] = null;
        }
        ind = 0;
    }

    void save(Resume r) {
        storage[ind] = r;
        ind++;
    }

    Resume get(String uuid) {
        Resume res = null;
        for (int i = 0; i < ind; i++) {
            if(storage[i].uuid.equals(uuid)) {
                res = storage[i];
                break;
            }
        }
        return res;
    }

    void delete(String uuid) {
        int startInd = 0;
        for (int i = 0; i < ind; i++) {
            if(storage[i].uuid.equals(uuid)){
                startInd = i;
                for (int j = startInd + 1; j < ind; j++) {
                    storage[j-1] = storage[j];
                }
                storage[ind-1] = null;
                --ind;
                return;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        /*Resume[] newstor = new Resume[ind];
        for (int i = 0; i < ind; i++) {
            newstor[i] = storage[i];
        }
        return newstor;*/
        return storage;
    }

    int size() {
        return ind;
    }
}
