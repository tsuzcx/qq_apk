import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;

public class dl
  implements Cloneable
{
  public ImageView A;
  private TextView N;
  public adxp a;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private dl.a jdField_a_of_type_Dl$a = new dl.a();
  private dl.b jdField_a_of_type_Dl$b = new dl.b();
  private dl.c jdField_a_of_type_Dl$c = new dl.c();
  private dl.d jdField_a_of_type_Dl$d = new dl.d();
  private dl.e jdField_a_of_type_Dl$e = new dl.e();
  private dl.f jdField_a_of_type_Dl$f = new dl.f();
  private dl.g jdField_a_of_type_Dl$g = new dl.g();
  private ProgressBar h;
  public RelativeLayout o;
  private Object r;
  private TextView time;
  
  public ProgressBar a()
  {
    return this.h;
  }
  
  public TextView a()
  {
    return this.time;
  }
  
  public DataLineMsgSet a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  }
  
  public dl.a a()
  {
    return this.jdField_a_of_type_Dl$a;
  }
  
  public dl.b a()
  {
    return this.jdField_a_of_type_Dl$b;
  }
  
  public dl.c a()
  {
    return this.jdField_a_of_type_Dl$c;
  }
  
  public dl.d a()
  {
    return this.jdField_a_of_type_Dl$d;
  }
  
  public dl.e a()
  {
    return this.jdField_a_of_type_Dl$e;
  }
  
  public dl.f a()
  {
    return this.jdField_a_of_type_Dl$f;
  }
  
  public dl.g a()
  {
    return this.jdField_a_of_type_Dl$g;
  }
  
  public void a(ImageView paramImageView)
  {
    this.A = paramImageView;
  }
  
  public void a(ProgressBar paramProgressBar)
  {
    this.h = paramProgressBar;
  }
  
  public void a(TextView paramTextView)
  {
    this.time = paramTextView;
  }
  
  public TextView b()
  {
    return this.N;
  }
  
  public void b(TextView paramTextView)
  {
    this.N = paramTextView;
  }
  
  public void b(DataLineMsgSet paramDataLineMsgSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
  }
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isDevelopLevel());
      QLog.w("Dataline.ItemHolder", 4, "ItemHolder clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
  
  public Object getTag()
  {
    return this.r;
  }
  
  public void setTag(Object paramObject)
  {
    this.r = paramObject;
  }
  
  public class a
  {
    public TextView M;
    public TextView O;
    public TextView P;
    public URLImageView a;
    public com.dataline.util.widget.AsyncImageView d;
    public com.dataline.util.widget.AsyncImageView e;
    public ProgressBar f;
    public com.dataline.util.widget.AsyncImageView f;
    public com.dataline.util.widget.AsyncImageView g;
    public TextView mFileName;
    public TextView mFileSize;
    public RelativeLayout n;
    public LinearLayout q;
    
    public a() {}
  }
  
  public class b
  {
    public TextView mText;
    
    public b() {}
  }
  
  public class c
  {
    public TextView P;
    public TextView Q;
    public TextView R;
    public URLImageView a;
    public MessageProgressTextView a;
    public com.dataline.util.widget.AsyncImageView h;
    public ProgressBar i;
    public RelativeLayout p;
    public LinearLayout q;
    public LinearLayout u;
    
    public c() {}
  }
  
  public class d
  {
    public TextView P;
    public TextView R;
    public TextView S;
    public GridView a;
    public URLImageView a;
    public ProgressBar f;
    public LinearLayout q;
    public RelativeLayout q;
    public LinearLayout u;
    
    public d() {}
  }
  
  public class e
  {
    public ImageView B;
    public ImageView C;
    public View E;
    public TextView T;
    public TextView U;
    public TextView V;
    public com.tencent.mobileqq.filemanager.widget.AsyncImageView a;
    public CircleFileStateView a;
    public CircleFileStateView b;
    public ProgressBar j;
    public RelativeLayout r;
    
    public e() {}
  }
  
  public class f
  {
    public String bM;
    public long mSessionId;
    public TextView mText;
    public RelativeLayout t;
    
    public f() {}
  }
  
  public class g
  {
    TextView mTextView;
    
    public g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dl
 * JD-Core Version:    0.7.0.1
 */