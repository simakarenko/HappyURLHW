package academy.prog;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("shorten")
    public UrlResultDTO shorten(@RequestBody UrlDTO urlDTO) {
        long id = urlService.saveUrl(urlDTO);

        var result = new UrlResultDTO();
        result.setUrl(urlDTO.getUrl());
        result.setShortUrl(Long.toString(id));

        return result;
    }


    @PostMapping("delete") //TODO: метод для видалення скорочених посилань
    public void delete(@RequestBody UrlDTO urlDTO) {
        long id = parsingShortUrl(urlDTO.getUrl());
        urlService.deleteUrl(id);
    }

    @GetMapping("my/{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") Long id) {
        var url = urlService.getUrl(id);

        var headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        headers.setCacheControl("no-cache, no-store, must-revalidate");

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("stat")
    public List<UrlStatDTO> stat() {
        return urlService.getStatistics();
    }


    private long parsingShortUrl(String urlName) { //TODO:метод для виокремлення id з рядка URL
        long result = Long.parseLong(urlName.substring(25));
        return result;
    }
}
