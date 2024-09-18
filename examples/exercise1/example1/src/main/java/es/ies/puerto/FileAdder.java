package es.ies.puerto;

import java.io.File;
import java.util.Objects;

public class FileAdder extends MyProcessManager {
  private File file;
  private String message;

  public FileAdder() {}

    public FileAdder(File file, String message) {
        this.file = file;
        this.message = message;
    }

  

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.file);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileAdder other = (FileAdder) obj;
        return Objects.equals(this.file, other.file);
    }
  
  
}
