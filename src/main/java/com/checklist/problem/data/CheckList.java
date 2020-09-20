package com.checklist.problem.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CheckList {
    private volatile ArrayList<String> taskList;
    private final Logger log = LoggerFactory.getLogger(CheckList.class);

    public CheckList() {
        taskList = new ArrayList<>();
    }

    public ArrayList<String> returnList() {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < taskList.size(); i++) {
            temp.add(i + " - " + this.taskList.get(i));
        }
        return temp;
    }

    public ArrayList<String> add(String item) {
        synchronized (taskList) {
            taskList.add(item);
        }
        return this.returnList();
    }

    public ArrayList<String> delete(int index) {
        synchronized (taskList) {
            try {
                taskList.remove(index);
            } catch (IndexOutOfBoundsException e) {
                log.info("Remove called with invalid index " + index);
            }
        }
        return this.returnList();
    }
}
