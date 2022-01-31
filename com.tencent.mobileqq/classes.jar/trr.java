import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class trr
  extends trw
{
  private bbjq a;
  
  public trr(Activity paramActivity)
  {
    super(paramActivity);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList = Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6 } });
    }
  }
  
  private List<bbjs>[] a(Context paramContext, List<int[]> paramList)
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
        bbjs localbbjs = new bbjs();
        localbbjs.c = a(m);
        localbbjs.jdField_b_of_type_Boolean = true;
        switch (m)
        {
        }
        for (;;)
        {
          localArrayList.add(localbbjs);
          j += 1;
          break;
          localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131719286);
          localbbjs.jdField_b_of_type_Int = 2130846011;
          vei.a("share", "exp_video", 0, 0, new String[0]);
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131719285);
          localbbjs.jdField_b_of_type_Int = 2130845903;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131696696);
          localbbjs.jdField_b_of_type_Int = 2130845903;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131696709);
          localbbjs.jdField_b_of_type_Int = 2130845530;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131696716);
          localbbjs.jdField_b_of_type_Int = 2130845906;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131696699);
          localbbjs.jdField_b_of_type_Int = 2130838752;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131696713);
          localbbjs.jdField_b_of_type_Int = 2130845905;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131691306);
          localbbjs.jdField_b_of_type_Int = 2130838750;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = ajya.a(2131699765);
          localbbjs.jdField_b_of_type_Int = 2130845769;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = ajya.a(2131699767);
          localbbjs.jdField_b_of_type_Int = 2130845767;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = ajya.a(2131699768);
          localbbjs.jdField_b_of_type_Int = 2130845768;
          continue;
          localbbjs.jdField_a_of_type_JavaLangString = ajya.a(2131699766);
          localbbjs.jdField_b_of_type_Int = 2130845775;
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
    trs localtrs;
    trt localtrt;
    Activity localActivity;
    String str;
    if (this.jdField_a_of_type_Bbjq == null)
    {
      localtrs = new trs(this);
      localtrt = new trt(this);
      localActivity = a();
      if (localActivity == null) {
        return;
      }
      this.jdField_a_of_type_Bbjq = new bbjq(localActivity, true);
      if (!this.jdField_a_of_type_Boolean) {
        break label162;
      }
      bbjq localbbjq = this.jdField_a_of_type_Bbjq;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label154;
      }
      str = localActivity.getString(2131719508);
      label82:
      localbbjq.a(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbjq.a(a(localActivity, this.jdField_a_of_type_JavaUtilList));
      this.jdField_a_of_type_Bbjq.a(localtrs);
      this.jdField_a_of_type_Bbjq.a(localtrt);
      this.jdField_a_of_type_Bbjq.a(new tru(this));
      if (this.jdField_a_of_type_Bbjq.a()) {
        break;
      }
      this.jdField_a_of_type_Bbjq.a();
      return;
      label154:
      str = this.jdField_a_of_type_JavaLangString;
      break label82;
      label162:
      this.jdField_a_of_type_Bbjq.f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     trr
 * JD-Core Version:    0.7.0.1
 */