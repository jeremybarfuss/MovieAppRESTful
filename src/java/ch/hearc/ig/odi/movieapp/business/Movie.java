package ch.hearc.ig.odi.movieapp.business;

import ch.hearc.ig.odi.movieapp.exception.UniqueException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe métier de personne.
 *
 * @author steven.habegger
 */
public class Movie {

    private long id;
    private String name;
    private String producer;
    HashMap<Long, Person> persons;

    /**
     * Constructeur de film
     *
     * @param id Identifiant du film
     * @param name Titre du film
     * @param producer Nom du producteur
     */
    public Movie(long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.persons = new HashMap<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * Renvoie les personnes ayant vu le film
     *
     * @return Liste de personnes
     */
    public HashMap<Long, Person> getPersons() {
        return persons;
    }

    /**
     * Modifie les personnes ayant vu le film
     *
     * @param persons Listes des nouvelles personnes
     */
    public void setMovies(HashMap<Long, Person> persons) {
        this.persons = persons;
    }

    /**
     * Renvoie une personne par son identifiant
     *
     * @param id Identifiant de la personne
     * @return Personne correspondant à l'identifiant
     */
    public Person getPersonById(long id) {
        return this.persons.get(id);
    }

    /**
     * Ajoute une personne à un film
     *
     * @param person Personne à ajouter au film
     */
    public void addPerson(Person person) throws UniqueException {
        if (this.persons.get(person.getId()) == null) {
            this.persons.put(person.getId(), person);
        } else {
            throw new UniqueException("Cette personne a déjà vu ce film");
        }
    }

    public void removePerson(Person person) throws UniqueException {
        if (this.persons.get(person.getId()) != null) {
            this.persons.remove(person.getId());
        } else {
            throw new UniqueException("Cette personne n'a pas vu ce film");
        }

    }

    @Override
    public String toString() {
        return this.id + " - " + this.name;
    }
    
    
}
