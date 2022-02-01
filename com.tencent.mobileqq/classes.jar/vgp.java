import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;

public class vgp
{
  public static final int a;
  public static final SparseArray<vgp> a;
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
    jdField_a_of_type_Int = vwt.b(5.0F);
    jdField_b_of_type_Int = vwt.b(10.0F);
    jdField_c_of_type_Int = vwt.b(1.5F);
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_d_of_type_Boolean = true;
  }
  
  private vgp(Context paramContext, int paramInt1, int paramInt2)
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
    this.jdField_d_of_type_Int = 8160;
    this.jdField_e_of_type_Int = (vwt.a(jdField_a_of_type_Int) + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + bnlc.a(BaseApplicationImpl.getApplication(), null));
    this.jdField_g_of_type_Int = vwt.a(16.0F);
    this.h = vwt.a(9.0F);
    this.jdField_b_of_type_Float = vwt.a(2.0F);
    this.jdField_c_of_type_Float = vwt.a(jdField_c_of_type_Int);
    this.jdField_f_of_type_Float = vwt.a(15.0F);
    this.jdField_g_of_type_Float = vwt.a(10.0F);
    this.i = 255;
    this.jdField_a_of_type_Float = vwt.a(14.0F);
    this.j = -1;
    this.m = 16;
    this.n = 200;
    this.jdField_d_of_type_Float = vwt.a(0.0F);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Float = vwt.a(6.0F);
    this.jdField_f_of_type_Int = 2;
    return;
    this.jdField_d_of_type_Int = 8160;
    this.jdField_e_of_type_Int = (vwt.a(24 + jdField_a_of_type_Int) + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()));
    this.jdField_g_of_type_Int = vwt.a(4.0F);
    this.h = vwt.a(9.0F);
    this.jdField_b_of_type_Float = vwt.a(2.0F);
    this.jdField_c_of_type_Float = vwt.a(jdField_c_of_type_Int);
    this.jdField_f_of_type_Float = vwt.a(15.0F);
    this.jdField_g_of_type_Float = vwt.a(10.0F);
    this.i = 255;
    this.jdField_a_of_type_Float = vwt.a(14.0F);
    this.j = -1;
    this.m = 10;
    this.n = 200;
    this.jdField_d_of_type_Float = vwt.a(0.0F);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Float = vwt.a(6.0F);
    this.jdField_f_of_type_Int = 2;
  }
  
  public static vgp a(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = (vgp)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1 * 10 + paramInt2);
    if (localObject == null) {
      try
      {
        vgp localvgp = (vgp)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1 * 10 + paramInt2);
        localObject = localvgp;
        if (localvgp == null)
        {
          localObject = new vgp(paramContext, paramInt1, paramInt2);
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
 * Qualified Name:     vgp
 * JD-Core Version:    0.7.0.1
 */