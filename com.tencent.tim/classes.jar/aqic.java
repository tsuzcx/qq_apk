import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

class aqic
  implements qqr.a
{
  aqic(aqhv paramaqhv) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramString = rnq.a();
    String str1 = ((Activity)this.this$0.context).getIntent().getStringExtra("from_type");
    paramInt = ((Activity)this.this$0.context).getIntent().getIntExtra("capture_intent_mode", -1);
    int i = ((Activity)this.this$0.context).getIntent().getIntExtra("firsttab", -1);
    int j = ((Activity)this.this$0.context).getIntent().getIntExtra("secondtab", -1);
    String str2 = ((Activity)this.this$0.context).getIntent().getStringExtra("itemid");
    String str3 = ((Activity)this.this$0.context).getIntent().getStringExtra("story_game_id");
    int k = ((Activity)this.this$0.context).getIntent().getIntExtra("key_finish_jump_to_page", 1);
    String str4 = ((Activity)this.this$0.context).getIntent().getStringExtra("web_dispatch_event");
    String str5 = ((Activity)this.this$0.context).getIntent().getStringExtra("story_capture_album_id");
    Bundle localBundle = new Bundle();
    if (TextUtils.equals(str1, "msgTab"))
    {
      localBundle.putInt("entrance_type", 103);
      localBundle.putInt("key_finish_jump_to_page", k);
      if (!TextUtils.isEmpty(str4)) {
        localBundle.putString("web_dispatch_event", str4);
      }
      if (paramInt == -1) {
        break label322;
      }
      paramString.a((Activity)this.this$0.context, localBundle, 2, paramInt, i, j, str2, str3, str5, true, 20000);
    }
    for (;;)
    {
      ram.i("Q.qqstory.publish.JumpAction", "launchNewVideoTakeActivity by StoryPublishLauncher");
      return;
      if (TextUtils.equals(str1, "msgTabNew"))
      {
        localBundle.putInt("entrance_type", 119);
        break;
      }
      localBundle.putInt("entrance_type", 15);
      break;
      label322:
      paramString.a((Activity)this.this$0.context, localBundle, 20000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqic
 * JD-Core Version:    0.7.0.1
 */