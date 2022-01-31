package android.support.v4.app;

import android.app.Notification.InboxStyle;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;

public class NotificationCompat$InboxStyle
  extends NotificationCompat.Style
{
  private ArrayList mTexts = new ArrayList();
  
  public NotificationCompat$InboxStyle() {}
  
  public NotificationCompat$InboxStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }
  
  public InboxStyle addLine(CharSequence paramCharSequence)
  {
    this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence));
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramNotificationBuilderWithBuilderAccessor = new Notification.InboxStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
      if (this.mSummaryTextSet) {
        paramNotificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
      }
      Iterator localIterator = this.mTexts.iterator();
      while (localIterator.hasNext()) {
        paramNotificationBuilderWithBuilderAccessor.addLine((CharSequence)localIterator.next());
      }
    }
  }
  
  public InboxStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public InboxStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.InboxStyle
 * JD-Core Version:    0.7.0.1
 */