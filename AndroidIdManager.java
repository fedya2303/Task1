import android.provider.Settings;
import android.content.Context;

public class AndroidIdManager {
    public String getAndroidId(Context context) {
   	return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }
}