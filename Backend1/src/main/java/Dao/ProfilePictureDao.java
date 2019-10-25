package Dao;

import Collabration.Backend1.ProfilePicture;

public interface ProfilePictureDao {
	void saveProfilePicture(ProfilePicture profilePicture);

	ProfilePicture getProfilePicture(String username);
}
