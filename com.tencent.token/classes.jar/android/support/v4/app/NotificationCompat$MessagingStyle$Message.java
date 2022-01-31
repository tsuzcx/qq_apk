package android.support.v4.app;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public final class NotificationCompat$MessagingStyle$Message
{
  static final String KEY_DATA_MIME_TYPE = "type";
  static final String KEY_DATA_URI = "uri";
  static final String KEY_EXTRAS_BUNDLE = "extras";
  static final String KEY_SENDER = "sender";
  static final String KEY_TEXT = "text";
  static final String KEY_TIMESTAMP = "time";
  private String mDataMimeType;
  private Uri mDataUri;
  private Bundle mExtras = new Bundle();
  private final CharSequence mSender;
  private final CharSequence mText;
  private final long mTimestamp;
  
  public NotificationCompat$MessagingStyle$Message(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
  {
    this.mText = paramCharSequence1;
    this.mTimestamp = paramLong;
    this.mSender = paramCharSequence2;
  }
  
  static Bundle[] getBundleArrayForMessages(List paramList)
  {
    Bundle[] arrayOfBundle = new Bundle[paramList.size()];
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      arrayOfBundle[i] = ((Message)paramList.get(i)).toBundle();
      i += 1;
    }
    return arrayOfBundle;
  }
  
  static Message getMessageFromBundle(Bundle paramBundle)
  {
    try
    {
      if ((paramBundle.containsKey("text")) && (paramBundle.containsKey("time")))
      {
        Message localMessage = new Message(paramBundle.getCharSequence("text"), paramBundle.getLong("time"), paramBundle.getCharSequence("sender"));
        if ((paramBundle.containsKey("type")) && (paramBundle.containsKey("uri"))) {
          localMessage.setData(paramBundle.getString("type"), (Uri)paramBundle.getParcelable("uri"));
        }
        if (paramBundle.containsKey("extras")) {
          localMessage.getExtras().putAll(paramBundle.getBundle("extras"));
        }
        return localMessage;
      }
    }
    catch (ClassCastException paramBundle)
    {
      return null;
    }
    return null;
  }
  
  static List getMessagesFromBundleArray(Parcelable[] paramArrayOfParcelable)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfParcelable.length);
    int i = 0;
    while (i < paramArrayOfParcelable.length)
    {
      if ((paramArrayOfParcelable[i] instanceof Bundle))
      {
        Message localMessage = getMessageFromBundle((Bundle)paramArrayOfParcelable[i]);
        if (localMessage != null) {
          localArrayList.add(localMessage);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    if (this.mText != null) {
      localBundle.putCharSequence("text", this.mText);
    }
    localBundle.putLong("time", this.mTimestamp);
    if (this.mSender != null) {
      localBundle.putCharSequence("sender", this.mSender);
    }
    if (this.mDataMimeType != null) {
      localBundle.putString("type", this.mDataMimeType);
    }
    if (this.mDataUri != null) {
      localBundle.putParcelable("uri", this.mDataUri);
    }
    if (this.mExtras != null) {
      localBundle.putBundle("extras", this.mExtras);
    }
    return localBundle;
  }
  
  public String getDataMimeType()
  {
    return this.mDataMimeType;
  }
  
  public Uri getDataUri()
  {
    return this.mDataUri;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public CharSequence getSender()
  {
    return this.mSender;
  }
  
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public long getTimestamp()
  {
    return this.mTimestamp;
  }
  
  public Message setData(String paramString, Uri paramUri)
  {
    this.mDataMimeType = paramString;
    this.mDataUri = paramUri;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.MessagingStyle.Message
 * JD-Core Version:    0.7.0.1
 */