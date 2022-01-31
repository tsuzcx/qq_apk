import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public abstract class xqv
{
  public int a;
  public Drawable a;
  public Object a;
  protected WeakReference<ImageView> a;
  public xqu a;
  protected xqw a;
  protected volatile boolean a;
  public Drawable b;
  
  public xqv(ImageView paramImageView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
  }
  
  public abstract String a();
  
  public abstract void a();
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Xqw != null) {
      this.jdField_a_of_type_Xqw.a(this);
    }
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Xqw != null) {
      this.jdField_a_of_type_Xqw.a(this, paramString);
    }
  }
  
  public void a(WeakHashMap<ImageView, Drawable> paramWeakHashMap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localImageView == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null));
    if ((paramBoolean) && (this.jdField_a_of_type_Int == 0))
    {
      wsv.a("Q.qqstory.newImageLoader", "save to waiting queue t:%s", this.jdField_a_of_type_JavaLangObject);
      paramWeakHashMap.put(localImageView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    wnb.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localImageView.getTag(2131369070), " and change to: ", this.jdField_a_of_type_JavaLangObject.toString(), " view hash:" + localImageView.hashCode() });
    localImageView.setTag(2131369070, this.jdField_a_of_type_JavaLangObject.toString());
  }
  
  public void a(xqw paramxqw)
  {
    this.jdField_a_of_type_Xqw = paramxqw;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    wnb.b("Q.qqstory.newImageLoader", new Object[] { alpo.a(2131715109), this.jdField_a_of_type_JavaLangObject });
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Xqw = null;
    this.jdField_a_of_type_Xqu = null;
    wnb.b("Q.qqstory.newImageLoader", new Object[] { alpo.a(2131715110), this.jdField_a_of_type_JavaLangObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqv
 * JD-Core Version:    0.7.0.1
 */