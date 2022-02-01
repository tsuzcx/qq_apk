import com.tencent.biz.qqstory.utils.JsonORM.a;

public class ptm
{
  @JsonORM.a(key="items")
  public ptm.b[] a;
  @JsonORM.a(key="id")
  public int id;
  @JsonORM.a(key="name")
  public String name;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("FilterConfig{id=").append(this.id).append(", name='").append(this.name).append('\'').append(", items-size=");
    if (this.a != null) {}
    for (int i = this.a.length;; i = 0) {
      return i + '}';
    }
  }
  
  public static class a
  {
    @JsonORM.a(key="align")
    public int bkg;
    @JsonORM.a(key="picture_width")
    public int bkh;
    @JsonORM.a(key="picture_height")
    public int bki;
    @JsonORM.a(key="standard_width")
    public int bkj;
    @JsonORM.a(key="picture_margin")
    public int[] dJ;
    @JsonORM.a(key="image")
    public String image;
  }
  
  public static class b
  {
    @JsonORM.a(key="content")
    public ptm.a a;
    @JsonORM.a(key="type")
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptm
 * JD-Core Version:    0.7.0.1
 */