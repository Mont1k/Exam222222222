package peaksoft.dao;

import peaksoft.model.SocialMedia;

public interface SocialMediaDao {
    void createTables();
    void deleteById(Long id);
    void saveSocialMedia(SocialMedia socialMedia);
}
