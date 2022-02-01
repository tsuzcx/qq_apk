import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class mhj
{
  public String agU;
  public String hotWord;
  public String indexBgColor;
  public boolean isReported;
  public String jumpUrl;
  
  public static mhj a(articlesummary.HotWordItem paramHotWordItem)
  {
    mhj localmhj = new mhj();
    if (paramHotWordItem.hot_word.has()) {
      localmhj.hotWord = paramHotWordItem.hot_word.get().toStringUtf8();
    }
    if (paramHotWordItem.jump_url.has()) {
      localmhj.jumpUrl = paramHotWordItem.jump_url.get().toStringUtf8();
    }
    if (paramHotWordItem.index_word_color.has()) {
      localmhj.agU = paramHotWordItem.index_word_color.get().toStringUtf8();
    }
    if (paramHotWordItem.index_bg_color.has()) {
      localmhj.indexBgColor = paramHotWordItem.index_bg_color.get().toStringUtf8();
    }
    return localmhj;
  }
  
  public articlesummary.HotWordItem a()
  {
    articlesummary.HotWordItem localHotWordItem = new articlesummary.HotWordItem();
    if (!TextUtils.isEmpty(this.hotWord)) {
      localHotWordItem.hot_word.set(ByteStringMicro.copyFromUtf8(this.hotWord));
    }
    if (!TextUtils.isEmpty(this.indexBgColor)) {
      localHotWordItem.index_bg_color.set(ByteStringMicro.copyFromUtf8(this.indexBgColor));
    }
    if (!TextUtils.isEmpty(this.agU)) {
      localHotWordItem.index_word_color.set(ByteStringMicro.copyFromUtf8(this.agU));
    }
    if (!TextUtils.isEmpty(this.jumpUrl)) {
      localHotWordItem.jump_url.set(ByteStringMicro.copyFromUtf8(this.jumpUrl));
    }
    return localHotWordItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof mhj)) {
      return (!TextUtils.isEmpty(this.hotWord)) && (this.hotWord.equals(((mhj)paramObject).hotWord)) && (!TextUtils.isEmpty(this.jumpUrl)) && (this.jumpUrl.equals(((mhj)paramObject).jumpUrl));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhj
 * JD-Core Version:    0.7.0.1
 */