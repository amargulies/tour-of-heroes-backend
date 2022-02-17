package ca.developy.tourOfHeroes.resource;

import ca.developy.tourOfHeroes.dao.HeroRepository;
import ca.developy.tourOfHeroes.dao.beans.Hero;
import ca.developy.tourOfHeroes.exception.HeroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hero")
@CrossOrigin(origins = "http://localhost:4200")
public class HeroResource {

    @Autowired
    HeroRepository heroRepository;

    @GetMapping(path = "/")
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Hero getHeroById(@PathVariable("id") int id) {
        Optional<Hero> heroOptional = heroRepository.findById(id);
        if(!heroOptional.isPresent()) {
            throw new HeroNotFoundException(String.format("id-%d", id));
        }
        return heroOptional.get();
    }

    @PutMapping(path = "/{id}")
    public Hero updateHeroById(@PathVariable("id") int id, @RequestBody  Hero hero) {
        return heroRepository.save(hero);
    }
}
