package com.layout.services;

import com.layout.repo.LayoutRepository;
import com.layout.repo.UserGroupRepository;
import com.layout.repo.UserRepository;
import com.layout.model.Layout;
import com.layout.model.User;
import com.layout.model.UserGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LayoutService {
    @Autowired
    private LayoutRepository layoutRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserGroupRepository userGroupRepository;
    
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
    public void assignLayoutToUserGroup(Long groupId, Long layoutId) {
        UserGroup group = userGroupRepository.findById(groupId)
                     .orElseThrow(() -> new RuntimeException("UserGroup not found"));
        Layout layout = layoutRepository.findById(layoutId)
                     .orElseThrow(() -> new RuntimeException("Layout not found"));
        group.setLayout(layout);
        userGroupRepository.save(group);
}
}

