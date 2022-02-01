import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;

public class vel
{
  public static final int a;
  public static final SparseArray<vel> a;
  public static final int b;
  public static final int c;
  public static boolean d;
  public float a;
  public boolean a;
  public float b;
  public boolean b;
  public float c;
  public boolean c;
  public float d;
  public int d;
  public float e;
  public int e;
  public float f;
  public int f;
  public float g;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  static
  {
    jdField_a_of_type_Int = vtu.b(5.0F);
    jdField_b_of_type_Int = vtu.b(10.0F);
    jdField_c_of_type_Int = vtu.b(1.5F);
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_d_of_type_Boolean = true;
  }
  
  private vel(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramInt1 = paramContext.widthPixels;
    int i1 = paramContext.heightPixels;
    if (BaseApplicationImpl.getContext().getResources().getConfiguration().orientation == 2) {
      this.l = Math.min(paramInt1, i1);
    }
    for (this.k = Math.max(paramInt1, i1);; this.k = Math.min(paramInt1, i1)) {
      switch (paramInt2)
      {
      default: 
        return;
        this.l = Math.max(paramInt1, i1);
      }
    }
    this.jdField_d_of_type_Int = 8000;
    this.jdField_e_of_type_Int = (vtu.a(jdField_a_of_type_Int) + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + bmjz.a(BaseApplicationImpl.getApplication(), null));
    this.jdField_g_of_type_Int = vtu.a(16.0F);
    this.h = vtu.a(9.0F);
    this.jdField_b_of_type_Float = vtu.a(2.0F);
    this.jdField_c_of_type_Float = vtu.a(jdField_c_of_type_Int);
    this.jdField_f_of_type_Float = vtu.a(15.0F);
    this.jdField_g_of_type_Float = vtu.a(10.0F);
    this.i = 255;
    this.jdField_a_of_type_Float = vtu.a(14.0F);
    this.j = -1;
    this.m = 16;
    this.n = 30;
    this.jdField_d_of_type_Float = vtu.a(0.0F);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Float = vtu.a(6.0F);
    this.jdField_f_of_type_Int = 2;
    return;
    this.jdField_d_of_type_Int = 8000;
    this.jdField_e_of_type_Int = (vtu.a(24 + jdField_a_of_type_Int) + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()));
    this.jdField_g_of_type_Int = vtu.a(4.0F);
    this.h = vtu.a(9.0F);
    this.jdField_b_of_type_Float = vtu.a(2.0F);
    this.jdField_c_of_type_Float = vtu.a(jdField_c_of_type_Int);
    this.jdField_f_of_type_Float = vtu.a(15.0F);
    this.jdField_g_of_type_Float = vtu.a(10.0F);
    this.i = 255;
    this.jdField_a_of_type_Float = vtu.a(14.0F);
    this.j = -1;
    this.m = 10;
    this.n = 30;
    this.jdField_d_of_type_Float = vtu.a(0.0F);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Float = vtu.a(6.0F);
    this.jdField_f_of_type_Int = 2;
  }
  
  public static vel a(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = (vel)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1 * 10 + paramInt2);
    if (localObject == null) {
      try
      {
        vel localvel = (vel)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1 * 10 + paramInt2);
        localObject = localvel;
        if (localvel == null)
        {
          localObject = new vel(paramContext, paramInt1, paramInt2);
          jdField_a_of_type_AndroidUtilSparseArray.put(paramInt1 * 10 + paramInt2, localObject);
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_d_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vel
 * JD-Core Version:    0.7.0.1
 */