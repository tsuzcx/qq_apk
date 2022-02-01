import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.Validator.1;
import java.util.Iterator;
import java.util.List;

public class armk
{
  private ShareActionSheetV2 b;
  private boolean mEnable = false;
  
  public armk(ShareActionSheetV2 paramShareActionSheetV2)
  {
    this.b = paramShareActionSheetV2;
  }
  
  private boolean aGR()
  {
    Object localObject = this.b.V;
    if ((localObject instanceof Activity))
    {
      localObject = ((Activity)localObject).getIntent();
      if (!TextUtils.isEmpty(((Intent)localObject).getStringExtra("big_brother_source_key"))) {
        return true;
      }
      if (!TextUtils.isEmpty(((Intent)localObject).getStringExtra("url"))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  private boolean isValidCreate()
  {
    List[] arrayOfList = this.b.a();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((ShareActionSheetBuilder.ActionSheetItem)localIterator.next()).isValidCreate()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isValidIcon()
  {
    List[] arrayOfList = this.b.a();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((ShareActionSheetBuilder.ActionSheetItem)localIterator.next()).isValidIcon()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isValidLabel()
  {
    List[] arrayOfList = this.b.a();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((ShareActionSheetBuilder.ActionSheetItem)localIterator.next()).isValidLabel()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private void showToast(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new Validator.1(this, paramString));
  }
  
  public boolean isValid()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!this.mEnable) {
      return true;
    }
    if (!aGR())
    {
      showToast("share component no biz id");
      bool1 = false;
    }
    if (!isValidIcon())
    {
      showToast("share component icon invalid");
      bool1 = false;
    }
    if (!isValidLabel())
    {
      showToast("share component label invalid");
      bool1 = false;
    }
    if (!isValidCreate())
    {
      showToast("share component item invalid");
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armk
 * JD-Core Version:    0.7.0.1
 */