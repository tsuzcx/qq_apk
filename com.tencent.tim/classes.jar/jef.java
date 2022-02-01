import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class jef
{
  public static final String TAG = jef.class.getSimpleName();
  private final int axL = 15;
  private int axM = 1000;
  private aure<izm> jdField_b_of_type_Aure;
  private iqu jdField_b_of_type_Iqu;
  private aure<izm> c;
  private aure<izm> jdField_d_of_type_Aure;
  private VideoAppInterface jdField_d_of_type_ComTencentAvAppVideoAppInterface;
  private Context mContext;
  
  public jef(Context paramContext, VideoAppInterface paramVideoAppInterface, iqu paramiqu)
  {
    this.mContext = paramContext;
    this.jdField_d_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_b_of_type_Iqu = paramiqu;
    this.jdField_b_of_type_Aure = new aure(15);
    this.c = new aure(15);
    this.jdField_d_of_type_Aure = new aure(15);
  }
  
  private boolean a(ArrayList<jfj> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((jfj)paramArrayList.next()).uin == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public izm a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (izm)this.jdField_b_of_type_Aure.get(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (izm)this.jdField_d_of_type_Aure.get(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.jdField_d_of_type_Aure.size() > 0)
        {
          i = this.jdField_d_of_type_Aure.size() - 1;
          localObject1 = (izm)this.jdField_d_of_type_Aure.valueAt(i);
          this.jdField_b_of_type_Aure.put(paramLong, localObject1);
          this.jdField_d_of_type_Aure.removeAt(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new izm(this.mContext, this.jdField_d_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { TAG, Integer.valueOf(1000) }), 0L, false);
          ((izm)localObject2).bU(2130843003, 2130843002);
          ((izm)localObject2).an(String.valueOf(paramLong), 0);
          ((izm)localObject2).kc(this.jdField_d_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((izm)localObject2).iH(true);
          ((izm)localObject2).jI(false);
          i = this.axM;
          this.axM = (i + 1);
          ((izm)localObject2).setZOrder(i);
          ((izm)localObject2).setTextSize(jll.dp2px(this.mContext, 12.0F));
          ((izm)localObject2).setMaxLength(12);
          ((izm)localObject2).setTextColor(-1);
          ((izm)localObject2).jL(true);
          ((izm)localObject2).setVisibility(1);
          this.jdField_b_of_type_Aure.put(paramLong, localObject2);
          this.jdField_b_of_type_Iqu.a((iqt)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((izm)localObject2).setTag(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void bF(ArrayList<jfj> paramArrayList)
  {
    int j = this.jdField_b_of_type_Aure.size();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_b_of_type_Aure.keyAt(i);
      izm localizm = (izm)this.jdField_b_of_type_Aure.valueAt(i);
      if (a(paramArrayList, l)) {
        this.c.put(l, localizm);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.jdField_d_of_type_Aure.size() + this.jdField_b_of_type_Aure.size() < 15) {
          this.jdField_d_of_type_Aure.put(l, localizm);
        } else {
          this.jdField_b_of_type_Iqu.a(localizm);
        }
      }
    }
    paramArrayList = this.jdField_b_of_type_Aure;
    this.jdField_b_of_type_Aure = this.c;
    this.c = paramArrayList;
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jef
 * JD-Core Version:    0.7.0.1
 */