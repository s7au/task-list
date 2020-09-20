package com.checklist.problem.web;

import com.checklist.problem.data.CheckList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("check-list")
public class CheckListEndpint {
    private final Logger log = LoggerFactory.getLogger(CheckListEndpint.class);

    @Autowired
    CheckList checkList;

    /**
     * @param String
     * @return String[]
     * @throws URISyntaxException
     * Call to add a number to list
     */
    @PutMapping("/add")
    public ResponseEntity<ArrayList<String>> addTask(@RequestBody String task) {
        return new ResponseEntity<>(this.checkList.add(task), HttpStatus.OK);
    }

    /**
     * @param int
     * @return String[]
     * @throws URISyntaxException
     * Call to delete item from list
     */
    @DeleteMapping("/remove/{index}")
    public ResponseEntity<ArrayList<String>> removeTask(@PathVariable int index) {
        return new ResponseEntity<>(this.checkList.delete(index), HttpStatus.OK);
    }

    /**
     * @return String[]
     * @throws URISyntaxException
     * Call to return list
     */
    @GetMapping()
    public ResponseEntity<ArrayList<String>> getList() {
        return new ResponseEntity<>(this.checkList.returnList(), HttpStatus.OK);
    }
}
