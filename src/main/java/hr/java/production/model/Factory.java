package hr.java.production.model;

import java.io.Serializable;
import java.util.Set;

/**
 * klasa koja sluzi za kreiranje objekata tvornice
 */
public class Factory extends NamedEntity implements Serializable {
    private Address address;
    private Set<Item> items;

    /**
     * sluzi za instanciranje objekata klase Factory
     *
     * @param name ime
     * @param address adresa
     * @param items artikli
     */
    public Factory(Long id, String name, Address address, Set<Item> items) {
        super(id, name);
        this.address = address;
        this.items = items;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
