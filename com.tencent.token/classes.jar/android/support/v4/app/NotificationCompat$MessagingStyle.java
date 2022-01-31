package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.MessagingStyle;
import android.app.Notification.MessagingStyle.Message;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat$MessagingStyle
  extends NotificationCompat.Style
{
  public static final int MAXIMUM_RETAINED_MESSAGES = 25;
  CharSequence mConversationTitle;
  List mMessages = new ArrayList();
  CharSequence mUserDisplayName;
  
  NotificationCompat$MessagingStyle() {}
  
  public NotificationCompat$MessagingStyle(@NonNull CharSequence paramCharSequence)
  {
    this.mUserDisplayName = paramCharSequence;
  }
  
  public static MessagingStyle extractMessagingStyleFromNotification(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    if ((paramNotification != null) && (!paramNotification.containsKey("android.selfDisplayName"))) {
      return null;
    }
    try
    {
      MessagingStyle localMessagingStyle = new MessagingStyle();
      localMessagingStyle.restoreFromCompatExtras(paramNotification);
      return localMessagingStyle;
    }
    catch (ClassCastException paramNotification) {}
    return null;
  }
  
  @Nullable
  private NotificationCompat.MessagingStyle.Message findLatestIncomingMessage()
  {
    int i = this.mMessages.size() - 1;
    while (i >= 0)
    {
      NotificationCompat.MessagingStyle.Message localMessage = (NotificationCompat.MessagingStyle.Message)this.mMessages.get(i);
      if (!TextUtils.isEmpty(localMessage.getSender())) {
        return localMessage;
      }
      i -= 1;
    }
    if (!this.mMessages.isEmpty()) {
      return (NotificationCompat.MessagingStyle.Message)this.mMessages.get(this.mMessages.size() - 1);
    }
    return null;
  }
  
  private boolean hasMessagesWithoutSender()
  {
    int i = this.mMessages.size() - 1;
    while (i >= 0)
    {
      if (((NotificationCompat.MessagingStyle.Message)this.mMessages.get(i)).getSender() == null) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  @NonNull
  private TextAppearanceSpan makeFontColorSpan(int paramInt)
  {
    return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(paramInt), null);
  }
  
  private CharSequence makeMessageLine(NotificationCompat.MessagingStyle.Message paramMessage)
  {
    BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int k;
    int i;
    label33:
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      k = 1;
      if (k == 0) {
        break label170;
      }
      i = -16777216;
      localObject = paramMessage.getSender();
      if (!TextUtils.isEmpty(paramMessage.getSender())) {
        break label192;
      }
      if (this.mUserDisplayName != null) {
        break label175;
      }
      localObject = "";
      label60:
      j = i;
      if (k != 0)
      {
        j = i;
        if (this.mBuilder.getColor() == 0) {}
      }
    }
    label170:
    label175:
    label192:
    for (int j = this.mBuilder.getColor();; j = i)
    {
      localObject = localBidiFormatter.unicodeWrap((CharSequence)localObject);
      localSpannableStringBuilder.append((CharSequence)localObject);
      localSpannableStringBuilder.setSpan(makeFontColorSpan(j), localSpannableStringBuilder.length() - ((CharSequence)localObject).length(), localSpannableStringBuilder.length(), 33);
      if (paramMessage.getText() == null) {}
      for (paramMessage = "";; paramMessage = paramMessage.getText())
      {
        localSpannableStringBuilder.append("  ").append(localBidiFormatter.unicodeWrap(paramMessage));
        return localSpannableStringBuilder;
        k = 0;
        break;
        i = -1;
        break label33;
        localObject = this.mUserDisplayName;
        break label60;
      }
    }
  }
  
  public void addCompatExtras(Bundle paramBundle)
  {
    super.addCompatExtras(paramBundle);
    if (this.mUserDisplayName != null) {
      paramBundle.putCharSequence("android.selfDisplayName", this.mUserDisplayName);
    }
    if (this.mConversationTitle != null) {
      paramBundle.putCharSequence("android.conversationTitle", this.mConversationTitle);
    }
    if (!this.mMessages.isEmpty()) {
      paramBundle.putParcelableArray("android.messages", NotificationCompat.MessagingStyle.Message.getBundleArrayForMessages(this.mMessages));
    }
  }
  
  public MessagingStyle addMessage(NotificationCompat.MessagingStyle.Message paramMessage)
  {
    this.mMessages.add(paramMessage);
    if (this.mMessages.size() > 25) {
      this.mMessages.remove(0);
    }
    return this;
  }
  
  public MessagingStyle addMessage(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
  {
    this.mMessages.add(new NotificationCompat.MessagingStyle.Message(paramCharSequence1, paramLong, paramCharSequence2));
    if (this.mMessages.size() > 25) {
      this.mMessages.remove(0);
    }
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject1 = new Notification.MessagingStyle(this.mUserDisplayName).setConversationTitle(this.mConversationTitle);
      localObject2 = this.mMessages.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        NotificationCompat.MessagingStyle.Message localMessage = (NotificationCompat.MessagingStyle.Message)((Iterator)localObject2).next();
        Notification.MessagingStyle.Message localMessage1 = new Notification.MessagingStyle.Message(localMessage.getText(), localMessage.getTimestamp(), localMessage.getSender());
        if (localMessage.getDataMimeType() != null) {
          localMessage1.setData(localMessage.getDataMimeType(), localMessage.getDataUri());
        }
        ((Notification.MessagingStyle)localObject1).addMessage(localMessage1);
      }
      ((Notification.MessagingStyle)localObject1).setBuilder(paramNotificationBuilderWithBuilderAccessor.getBuilder());
    }
    label187:
    do
    {
      return;
      localObject1 = findLatestIncomingMessage();
      if (this.mConversationTitle == null) {
        break;
      }
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
      if (localObject1 != null)
      {
        localObject2 = paramNotificationBuilderWithBuilderAccessor.getBuilder();
        if (this.mConversationTitle == null) {
          break label335;
        }
        localObject1 = makeMessageLine((NotificationCompat.MessagingStyle.Message)localObject1);
        ((Notification.Builder)localObject2).setContentText((CharSequence)localObject1);
      }
    } while (Build.VERSION.SDK_INT < 16);
    Object localObject2 = new SpannableStringBuilder();
    int i;
    label228:
    int j;
    if ((this.mConversationTitle != null) || (hasMessagesWithoutSender()))
    {
      i = 1;
      j = this.mMessages.size() - 1;
      label240:
      if (j < 0) {
        break label360;
      }
      localObject1 = (NotificationCompat.MessagingStyle.Message)this.mMessages.get(j);
      if (i == 0) {
        break label350;
      }
    }
    label335:
    label350:
    for (Object localObject1 = makeMessageLine((NotificationCompat.MessagingStyle.Message)localObject1);; localObject1 = ((NotificationCompat.MessagingStyle.Message)localObject1).getText())
    {
      if (j != this.mMessages.size() - 1) {
        ((SpannableStringBuilder)localObject2).insert(0, "\n");
      }
      ((SpannableStringBuilder)localObject2).insert(0, (CharSequence)localObject1);
      j -= 1;
      break label240;
      if (localObject1 == null) {
        break;
      }
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(((NotificationCompat.MessagingStyle.Message)localObject1).getSender());
      break;
      localObject1 = ((NotificationCompat.MessagingStyle.Message)localObject1).getText();
      break label187;
      i = 0;
      break label228;
    }
    label360:
    new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText((CharSequence)localObject2);
  }
  
  public CharSequence getConversationTitle()
  {
    return this.mConversationTitle;
  }
  
  public List getMessages()
  {
    return this.mMessages;
  }
  
  public CharSequence getUserDisplayName()
  {
    return this.mUserDisplayName;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void restoreFromCompatExtras(Bundle paramBundle)
  {
    this.mMessages.clear();
    this.mUserDisplayName = paramBundle.getString("android.selfDisplayName");
    this.mConversationTitle = paramBundle.getString("android.conversationTitle");
    paramBundle = paramBundle.getParcelableArray("android.messages");
    if (paramBundle != null) {
      this.mMessages = NotificationCompat.MessagingStyle.Message.getMessagesFromBundleArray(paramBundle);
    }
  }
  
  public MessagingStyle setConversationTitle(CharSequence paramCharSequence)
  {
    this.mConversationTitle = paramCharSequence;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.MessagingStyle
 * JD-Core Version:    0.7.0.1
 */