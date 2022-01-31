import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public abstract class wcd
{
  public int a;
  public Drawable a;
  public Object a;
  protected WeakReference<ImageView> a;
  public wcc a;
  protected wce a;
  protected volatile boolean a;
  public Drawable b;
  
  public wcd(ImageView paramImageView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
  }
  
  public abstract String a();
  
  public abstract void a();
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Wce != null) {
      this.jdField_a_of_type_Wce.a(this);
    }
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Wce != null) {
      this.jdField_a_of_type_Wce.a(this, paramString);
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
      ved.a("Q.qqstory.newImageLoader", "save to waiting queue t:%s", this.jdField_a_of_type_JavaLangObject);
      paramWeakHashMap.put(localImageView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    uyj.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localImageView.getTag(2131368841), " and change to: ", this.jdField_a_of_type_JavaLangObject.toString(), " view hash:" + localImageView.hashCode() });
    localImageView.setTag(2131368841, this.jdField_a_of_type_JavaLangObject.toString());
  }
  
  public void a(wce paramwce)
  {
    this.jdField_a_of_type_Wce = paramwce;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    uyj.b("Q.qqstory.newImageLoader", new Object[] { ajya.a(2131714737), this.jdField_a_of_type_JavaLangObject });
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Wce = null;
    this.jdField_a_of_type_Wcc = null;
    uyj.b("Q.qqstory.newImageLoader", new Object[] { ajya.a(2131714738), this.jdField_a_of_type_JavaLangObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wcd
 * JD-Core Version:    0.7.0.1
 */