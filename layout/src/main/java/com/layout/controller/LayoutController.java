package com.layout.controller;

import com.layout.model.Layout;
import com.layout.services.LayoutService; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.layout.Request.AssignLayoutRequest;
import com.layout.Request.UpdateLayoutRequest;

@RestController
@RequestMapping("/api/layouts")
public class LayoutController {
    @Autowired
    private LayoutService layoutService;

    @GetMapping("/admin")
    public ResponseEntity<List<Layout>> getAllLayouts() {
        return ResponseEntity.ok(layoutService.getAllLayouts());
    }

    @PostMapping("/assign")
    public ResponseEntity<String> assignLayoutToUser(@RequestBody AssignLayoutRequest request) {
        layoutService.assignLayoutToUser(request.getUserId(), request.getLayoutId());
        return ResponseEntity.ok("Layout assigned successfully!");
    }

    @GetMapping("/user")
    public ResponseEntity<Layout> getUserLayout(@RequestParam Long userId) {
        return ResponseEntity.ok(layoutService.getUserLayout(userId));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUserLayout(@RequestBody UpdateLayoutRequest request) {
        layoutService.assignLayoutToUser(request.getUserId(), request.getLayoutId());
        return ResponseEntity.ok("Layout updated successfully!");
    }
}
