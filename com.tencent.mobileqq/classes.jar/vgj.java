import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class vgj
  extends vgo
{
  private ShareActionSheetBuilder a;
  
  public vgj(Activity paramActivity)
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
          localActionSheetItem.label = paramContext.getString(2131719767);
          localActionSheetItem.icon = 2130846390;
          wta.a("share", "exp_video", 0, 0, new String[0]);
          continue;
          localActionSheetItem.label = paramContext.getString(2131719766);
          localActionSheetItem.icon = 2130846282;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696871);
          localActionSheetItem.icon = 2130846282;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696884);
          localActionSheetItem.icon = 2130845909;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696891);
          localActionSheetItem.icon = 2130846285;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696874);
          localActionSheetItem.icon = 2130838914;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696888);
          localActionSheetItem.icon = 2130846284;
          continue;
          localActionSheetItem.label = paramContext.getString(2131691359);
          localActionSheetItem.icon = 2130838912;
          continue;
          localActionSheetItem.label = alpo.a(2131700134);
          localActionSheetItem.icon = 2130846148;
          continue;
          localActionSheetItem.label = alpo.a(2131700136);
          localActionSheetItem.icon = 2130846146;
          continue;
          localActionSheetItem.label = alpo.a(2131700137);
          localActionSheetItem.icon = 2130846147;
          continue;
          localActionSheetItem.label = alpo.a(2131700135);
          localActionSheetItem.icon = 2130846154;
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
    vgk localvgk;
    vgl localvgl;
    Activity localActivity;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      localvgk = new vgk(this);
      localvgl = new vgl(this);
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
      str = localActivity.getString(2131720040);
      label82:
      localShareActionSheetBuilder.setActionSheetTitle(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(localActivity, this.jdField_a_of_type_JavaUtilList));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(localvgk);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(localvgl);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new vgm(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgj
 * JD-Core Version:    0.7.0.1
 */