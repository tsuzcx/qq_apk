import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tru
  extends trz
{
  private bbjc a;
  
  public tru(Activity paramActivity)
  {
    super(paramActivity);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList = Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6 } });
    }
  }
  
  private List<bbje>[] a(Context paramContext, List<int[]> paramList)
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
        bbje localbbje = new bbje();
        localbbje.c = a(m);
        localbbje.jdField_b_of_type_Boolean = true;
        switch (m)
        {
        }
        for (;;)
        {
          localArrayList.add(localbbje);
          j += 1;
          break;
          localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131719275);
          localbbje.jdField_b_of_type_Int = 2130846005;
          vel.a("share", "exp_video", 0, 0, new String[0]);
          continue;
          localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131719274);
          localbbje.jdField_b_of_type_Int = 2130845897;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131696695);
          localbbje.jdField_b_of_type_Int = 2130845897;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131696708);
          localbbje.jdField_b_of_type_Int = 2130845524;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131696715);
          localbbje.jdField_b_of_type_Int = 2130845900;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131696698);
          localbbje.jdField_b_of_type_Int = 2130838752;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131696712);
          localbbje.jdField_b_of_type_Int = 2130845899;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131691306);
          localbbje.jdField_b_of_type_Int = 2130838750;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = ajyc.a(2131699754);
          localbbje.jdField_b_of_type_Int = 2130845763;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = ajyc.a(2131699756);
          localbbje.jdField_b_of_type_Int = 2130845761;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = ajyc.a(2131699757);
          localbbje.jdField_b_of_type_Int = 2130845762;
          continue;
          localbbje.jdField_a_of_type_JavaLangString = ajyc.a(2131699755);
          localbbje.jdField_b_of_type_Int = 2130845769;
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
    trv localtrv;
    trw localtrw;
    Activity localActivity;
    String str;
    if (this.jdField_a_of_type_Bbjc == null)
    {
      localtrv = new trv(this);
      localtrw = new trw(this);
      localActivity = a();
      if (localActivity == null) {
        return;
      }
      this.jdField_a_of_type_Bbjc = new bbjc(localActivity, true);
      if (!this.jdField_a_of_type_Boolean) {
        break label162;
      }
      bbjc localbbjc = this.jdField_a_of_type_Bbjc;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label154;
      }
      str = localActivity.getString(2131719497);
      label82:
      localbbjc.a(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbjc.a(a(localActivity, this.jdField_a_of_type_JavaUtilList));
      this.jdField_a_of_type_Bbjc.a(localtrv);
      this.jdField_a_of_type_Bbjc.a(localtrw);
      this.jdField_a_of_type_Bbjc.a(new trx(this));
      if (this.jdField_a_of_type_Bbjc.a()) {
        break;
      }
      this.jdField_a_of_type_Bbjc.a();
      return;
      label154:
      str = this.jdField_a_of_type_JavaLangString;
      break label82;
      label162:
      this.jdField_a_of_type_Bbjc.f();
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
 * Qualified Name:     tru
 * JD-Core Version:    0.7.0.1
 */