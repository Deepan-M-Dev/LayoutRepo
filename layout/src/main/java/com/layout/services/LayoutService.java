package com.layout.services;

import com.layout.repo.LayoutRepository;
import com.layout.repo.UserRepository;
import com.layout.model.Layout;
import com.layout.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LayoutService {
    @Autowired
    private LayoutRepository layoutRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Layout> getAllLayouts() {
        return layoutRepository.findAll();
    }

    public void assignLayoutToUser(Long userId, Long layoutId) {
        User user = userRepository.findById(userId)
                     .orElseThrow(() -> new RuntimeException("User not found"));

        Layout layout = layoutRepository.findById(layoutId)
                     .orElseThrow(() -> new RuntimeException("Layout not found"));

        user.setAssignedLayout(layout);
        userRepository.save(user);
    }

    public Layout getUserLayout(Long userId) {
        User user = userRepository.findById(userId)
                     .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getAssignedLayout();
    }
}

