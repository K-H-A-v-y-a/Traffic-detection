package traffic.detection.DistanceController;

import traffic.detection.DistanceService.DistanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {
	private final DistanceService distanceService;

    public DistanceController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }
    
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
    
    @GetMapping("/distance")
    public String getDistance(@RequestParam String origin, @RequestParam String destination) {
        return distanceService.getDistance(origin, destination);
    }
    
    @GetMapping("/trafficSeverity")
    public String getTrafficSeverity(@RequestParam String origin,
                                     @RequestParam String destination,
                                     @RequestParam String departure_time,
                                     @RequestParam String mode) {
        return distanceService.getTrafficSeverity(origin, destination, departure_time, mode);
    }
    
    @GetMapping("/map")
    public String getMapPage() {
        return "map"; // This will serve the HTML page from resources/templates
    }
}
