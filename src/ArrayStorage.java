/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int countResumes = 0;

    void clear() {
        for (int i = 0; i < countResumes; i++) {
            storage[i] = null;
        }
        countResumes = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < countResumes; i++) {
            if(storage[i].uuid.equals(r.uuid)) return;
        }
        storage[countResumes] = r;
        countResumes++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if(storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int startInd;
        for (int i = 0; i < countResumes; i++) {
            if(storage[i].uuid.equals(uuid)){
                startInd = i;
                storage[startInd] = storage[countResumes-1];
                storage[countResumes-1] = null;
                countResumes--;
                return;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newstor = new Resume[countResumes];
        for (int i = 0; i < countResumes; i++) {
            newstor[i] = storage[i];
        }
        return newstor;

    }

    int size() {
        return countResumes;
    }
}
