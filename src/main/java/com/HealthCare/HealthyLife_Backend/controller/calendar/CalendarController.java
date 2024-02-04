package com.HealthCare.HealthyLife_Backend.controller.calendar;

import com.HealthCare.HealthyLife_Backend.dto.calendar.CalendarDto;
import com.HealthCare.HealthyLife_Backend.service.calendar.CalendarService;
import com.HealthCare.HealthyLife_Backend.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/calendar")
public class CalendarController  {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/test")
    public ResponseEntity<?> testController () {
        try {
            System.out.println("확인");
            // return ResponseEntity.ok("Food search");
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("정상작동");
    }

//    @PostMapping("/new")
//    public ResponseEntity<Boolean> insert(@RequestBody CalendarDto calendarDto) {
//        try {
//            boolean isTrue = calendarService.saveCalendar(calendarDto);
//            return ResponseEntity.ok(isTrue);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CalendarDto>> findAll() {

        try {
            List<CalendarDto> calendars = calendarService.findAll();
            return ResponseEntity.ok(calendars);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<CalendarDto> findById(Long id) {
        try {
            CalendarDto calendar = calendarService.findById(id);
            return calendar != null ? ResponseEntity.ok(calendar) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            calendarService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CalendarDto> update(@PathVariable Long id, @RequestBody CalendarDto calendarDto) {
        try {
            CalendarDto updatedCalendar = calendarService.update(id, calendarDto);
            return ResponseEntity.ok(updatedCalendar);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
