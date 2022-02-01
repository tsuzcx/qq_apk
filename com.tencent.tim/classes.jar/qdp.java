import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class qdp
  extends qdu
{
  private ShareActionSheetBuilder mShareActionSheet;
  
  public qdp(Activity paramActivity)
  {
    super(paramActivity);
    if ((this.nK == null) || (this.nK.isEmpty())) {
      this.nK = Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6 } });
    }
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext, List<int[]> paramList)
  {
    List[] arrayOfList = (List[])new ArrayList[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      int[] arrayOfInt = (int[])paramList.get(i);
      ArrayList localArrayList = new ArrayList();
      int k = arrayOfInt.length;
      int j = 0;
      if (j < k)
      {
        int m = arrayOfInt[j];
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.action = dQ(m);
        localActionSheetItem.iconNeedBg = true;
        switch (m)
        {
        }
        for (;;)
        {
          localArrayList.add(localActionSheetItem);
          j += 1;
          break;
          localActionSheetItem.label = paramContext.getString(2131719511);
          localActionSheetItem.icon = 2130847784;
          rar.a("share", "exp_video", 0, 0, new String[0]);
          continue;
          localActionSheetItem.label = paramContext.getString(2131719510);
          localActionSheetItem.icon = 2130847676;
          continue;
          localActionSheetItem.label = paramContext.getString(2131698630);
          localActionSheetItem.icon = 2130847676;
          continue;
          localActionSheetItem.label = paramContext.getString(2131698643);
          localActionSheetItem.icon = 2130847303;
          continue;
          localActionSheetItem.label = paramContext.getString(2131698652);
          localActionSheetItem.icon = 2130847679;
          continue;
          localActionSheetItem.label = paramContext.getString(2131698633);
          localActionSheetItem.icon = 2130839249;
          continue;
          localActionSheetItem.label = paramContext.getString(2131698647);
          localActionSheetItem.icon = 2130847678;
          continue;
          localActionSheetItem.label = paramContext.getString(2131692329);
          localActionSheetItem.icon = 2130839246;
          continue;
          localActionSheetItem.label = acfp.m(2131701983);
          localActionSheetItem.icon = 2130847542;
          continue;
          localActionSheetItem.label = acfp.m(2131701985);
          localActionSheetItem.icon = 2130847540;
          continue;
          localActionSheetItem.label = acfp.m(2131701986);
          localActionSheetItem.icon = 2130847541;
          continue;
          localActionSheetItem.label = acfp.m(2131701984);
          localActionSheetItem.icon = 2130847548;
        }
      }
      arrayOfList[i] = localArrayList;
      i += 1;
    }
    return arrayOfList;
  }
  
  public int dQ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 9;
    case 4: 
      return 10;
    case 5: 
      return 12;
    case 6: 
      return 1;
    case 7: 
      return 39;
    case 8: 
      return 40;
    case 9: 
      return 11;
    case 10: 
      return 41;
    case 11: 
      return 22;
    }
    return 42;
  }
  
  public int dR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 9: 
      return 3;
    case 10: 
      return 4;
    case 12: 
      return 5;
    case 1: 
      return 6;
    case 39: 
      return 7;
    case 40: 
      return 8;
    case 11: 
      return 9;
    case 41: 
      return 10;
    case 22: 
      return 11;
    }
    return 12;
  }
  
  public void onShow()
  {
    qdq localqdq;
    qdr localqdr;
    Activity localActivity;
    String str;
    if (this.mShareActionSheet == null)
    {
      localqdq = new qdq(this);
      localqdr = new qdr(this);
      localActivity = m();
      if (localActivity == null) {
        return;
      }
      this.mShareActionSheet = new ShareActionSheetBuilder(localActivity, true);
      if (!this.mShowTitle) {
        break label162;
      }
      ShareActionSheetBuilder localShareActionSheetBuilder = this.mShareActionSheet;
      if (!TextUtils.isEmpty(this.mTitle)) {
        break label154;
      }
      str = localActivity.getString(2131720177);
      label82:
      localShareActionSheetBuilder.setActionSheetTitle(str);
    }
    for (;;)
    {
      this.mShareActionSheet.setActionSheetItems(a(localActivity, this.nK));
      this.mShareActionSheet.setItemClickListener(localqdq);
      this.mShareActionSheet.setOnDismissListener(localqdr);
      this.mShareActionSheet.setCancelListener(new qds(this));
      if (this.mShareActionSheet.isShowing()) {
        break;
      }
      this.mShareActionSheet.show();
      return;
      label154:
      str = this.mTitle;
      break label82;
      label162:
      this.mShareActionSheet.hideTitle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdp
 * JD-Core Version:    0.7.0.1
 */