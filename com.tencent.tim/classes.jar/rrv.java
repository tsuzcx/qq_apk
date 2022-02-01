import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public abstract class rrv
{
  public rru a;
  protected rrv.a a;
  protected volatile boolean aJw;
  public Drawable defaultDrawable;
  protected WeakReference<ImageView> dl;
  public Drawable jdField_do;
  public int flag;
  public Object source;
  
  public rrv(ImageView paramImageView)
  {
    this.dl = new WeakReference(paramImageView);
  }
  
  public void L(Drawable paramDrawable)
  {
    this.jdField_do = paramDrawable;
    if (this.jdField_a_of_type_Rrv$a != null) {
      this.jdField_a_of_type_Rrv$a.b(this);
    }
  }
  
  public boolean LY()
  {
    return this.aJw;
  }
  
  public void a(WeakHashMap<ImageView, Drawable> paramWeakHashMap, boolean paramBoolean)
  {
    if (this.aJw) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.dl.get();
    } while ((localImageView == null) || (this.jdField_do == null));
    if ((paramBoolean) && (this.flag == 0))
    {
      ram.b("Q.qqstory.newImageLoader", "save to waiting queue t:%s", this.source);
      paramWeakHashMap.put(localImageView, this.jdField_do);
      return;
    }
    localImageView.setImageDrawable(this.jdField_do);
    qwp.d("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localImageView.getTag(2131370080), " and change to: ", this.source.toString(), " view hash:" + localImageView.hashCode() });
    localImageView.setTag(2131370080, this.source.toString());
  }
  
  public void a(rrv.a parama)
  {
    this.jdField_a_of_type_Rrv$a = parama;
  }
  
  public abstract void bri();
  
  public void cancel()
  {
    this.aJw = true;
    qwp.d("Q.qqstory.newImageLoader", new Object[] { acfp.m(2131715124), this.source });
  }
  
  public void f(Drawable paramDrawable, String paramString)
  {
    this.jdField_do = paramDrawable;
    if (this.jdField_a_of_type_Rrv$a != null) {
      this.jdField_a_of_type_Rrv$a.a(this, paramString);
    }
  }
  
  public abstract String key();
  
  public void release()
  {
    this.jdField_do = null;
    this.jdField_a_of_type_Rrv$a = null;
    this.jdField_a_of_type_Rru = null;
    qwp.d("Q.qqstory.newImageLoader", new Object[] { acfp.m(2131715125), this.source });
  }
  
  public static abstract interface a
  {
    public abstract void a(rrv paramrrv, String paramString);
    
    public abstract void b(rrv paramrrv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrv
 * JD-Core Version:    0.7.0.1
 */