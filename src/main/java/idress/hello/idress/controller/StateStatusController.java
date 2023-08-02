package idress.hello.idress.controller;

import idress.hello.idress.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StateStatusController {

    private final DataService dataService;



}
