import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

public class rnp
{
  public static void a(@NonNull LayoutInflater paramLayoutInflater, @NonNull LayoutInflater.Factory paramFactory)
  {
    try
    {
      paramLayoutInflater.setFactory(paramFactory);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      rnp.b.d("LayoutModifier", "LayoutInflater.setFactory IllegalStateException " + localIllegalStateException);
      try
      {
        Field localField1 = LayoutInflater.class.getDeclaredField("mFactory");
        localField1.setAccessible(true);
        Field localField2 = LayoutInflater.class.getDeclaredField("mFactory2");
        localField2.setAccessible(true);
        localField1.set(paramLayoutInflater, paramFactory);
        localField2.set(paramLayoutInflater, paramFactory);
        if ((paramLayoutInflater.getFactory() == paramFactory) && (paramLayoutInflater.getFactory2() == paramFactory))
        {
          rnp.b.i("LayoutModifier", "hookLayoutInflaterFactory success");
          return;
        }
      }
      catch (Exception paramLayoutInflater)
      {
        rnp.b.e("LayoutModifier", "hook setFactory " + paramLayoutInflater);
        return;
      }
      rnp.b.i("LayoutModifier", "hookLayoutInflaterFactory failed");
    }
  }
  
  public static class a
    implements LayoutInflater.Factory2
  {
    private final LayoutInflater.Factory2 jdField_a_of_type_AndroidViewLayoutInflater$Factory2;
    private final LayoutInflater.Factory jdField_a_of_type_AndroidViewLayoutInflater$Factory;
    private final LayoutInflater mLayoutInflater;
    
    public a(@NonNull LayoutInflater paramLayoutInflater)
    {
      this.mLayoutInflater = paramLayoutInflater;
      this.jdField_a_of_type_AndroidViewLayoutInflater$Factory = paramLayoutInflater.getFactory();
      this.jdField_a_of_type_AndroidViewLayoutInflater$Factory2 = paramLayoutInflater.getFactory2();
    }
    
    protected View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      rnp.b.v("LayoutModifier", "onCreateViewPrivate " + paramString);
      return null;
    }
    
    public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      View localView2 = a(paramView, paramString, paramContext, paramAttributeSet);
      View localView1 = localView2;
      if (localView2 == null)
      {
        localView1 = localView2;
        if (this.jdField_a_of_type_AndroidViewLayoutInflater$Factory2 != null) {
          localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater$Factory2.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
        }
      }
      rnp.b.v("LayoutModifier", "onCreateView " + localView1);
      return localView1;
    }
    
    public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      View localView2 = a(null, paramString, paramContext, paramAttributeSet);
      View localView1 = localView2;
      if (localView2 == null)
      {
        localView1 = localView2;
        if (this.jdField_a_of_type_AndroidViewLayoutInflater$Factory != null) {
          localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater$Factory.onCreateView(paramString, paramContext, paramAttributeSet);
        }
      }
      rnp.b.v("LayoutModifier", "onCreateView " + localView1);
      return localView1;
    }
  }
  
  static class b
  {
    static void d(String paramString1, String paramString2) {}
    
    static void e(String paramString1, String paramString2) {}
    
    static void i(String paramString1, String paramString2) {}
    
    static void v(String paramString1, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnp
 * JD-Core Version:    0.7.0.1
 */