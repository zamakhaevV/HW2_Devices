package part;

public class Component {
    private Integer id;
    private String name;
    private Boolean status;

    public Component(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.status = true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("[id = %d, name = %s, status = %s]", id, name, status);
    }
}
