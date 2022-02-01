import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class xhz
  extends xie
{
  private ShareActionSheetBuilder a;
  
  public xhz(Activity paramActivity)
  {
    super(paramActivity);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList = Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6 } });
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
        localActionSheetItem.action = a(m);
        localActionSheetItem.iconNeedBg = true;
        switch (m)
        {
        }
        for (;;)
        {
          localArrayList.add(localActionSheetItem);
          j += 1;
          break;
          localActionSheetItem.label = paramContext.getString(2131717897);
          localActionSheetItem.icon = 2130846918;
          yup.a("share", "exp_video", 0, 0, new String[0]);
          continue;
          localActionSheetItem.label = paramContext.getString(2131717896);
          localActionSheetItem.icon = 2130846811;
          continue;
          localActionSheetItem.label = paramContext.getString(2131695738);
          localActionSheetItem.icon = 2130846811;
          continue;
          localActionSheetItem.label = paramContext.getString(2131695751);
          localActionSheetItem.icon = 2130846438;
          continue;
          localActionSheetItem.label = paramContext.getString(2131695758);
          localActionSheetItem.icon = 2130846814;
          continue;
          localActionSheetItem.label = paramContext.getString(2131695741);
          localActionSheetItem.icon = 2130839089;
          continue;
          localActionSheetItem.label = paramContext.getString(2131695755);
          localActionSheetItem.icon = 2130846813;
          continue;
          localActionSheetItem.label = paramContext.getString(2131691139);
          localActionSheetItem.icon = 2130839087;
          continue;
          localActionSheetItem.label = anzj.a(2131698679);
          localActionSheetItem.icon = 2130846677;
          continue;
          localActionSheetItem.label = anzj.a(2131698681);
          localActionSheetItem.icon = 2130846675;
          continue;
          localActionSheetItem.label = anzj.a(2131698682);
          localActionSheetItem.icon = 2130846676;
          continue;
          localActionSheetItem.label = anzj.a(2131698680);
          localActionSheetItem.icon = 2130846683;
        }
      }
      arrayOfList[i] = localArrayList;
      i += 1;
    }
    return arrayOfList;
  }
  
  public int a(int paramInt)
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
  
  public void a()
  {
    xia localxia;
    xib localxib;
    Activity localActivity;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      localxia = new xia(this);
      localxib = new xib(this);
      localActivity = a();
      if (localActivity == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(localActivity, true);
      if (!this.jdField_a_of_type_Boolean) {
        break label162;
      }
      ShareActionSheetBuilder localShareActionSheetBuilder = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label154;
      }
      str = localActivity.getString(2131718159);
      label82:
      localShareActionSheetBuilder.setActionSheetTitle(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(localActivity, this.jdField_a_of_type_JavaUtilList));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(localxia);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(localxib);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new xic(this));
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
      label154:
      str = this.jdField_a_of_type_JavaLangString;
      break label82;
      label162:
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.hideTitle();
    }
  }
  
  public int b(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhz
 * JD-Core Version:    0.7.0.1
 */