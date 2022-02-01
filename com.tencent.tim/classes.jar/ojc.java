import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView.a;

class ojc
  implements FeedRichTextView.a
{
  ojc(oiy paramoiy) {}
  
  public void pF(String paramString)
  {
    ooz.d("WSFollowFeedHolder", "[onUserClick] uid: " + paramString);
    paramString = "weishi://profile?person_id=" + paramString;
    oor.a(oiy.a(this.a).getActivity(), paramString, 700, oiy.a(this.a), "content");
    oiy.a(this.a, "content");
  }
  
  public void pG(String paramString)
  {
    ooz.d("WSFollowFeedHolder", "[onTopicClick] tid: " + paramString);
    paramString = "weishi://topic?topic_id=" + paramString;
    oor.a(oiy.a(this.a).getActivity(), paramString, 700, oiy.a(this.a), "content");
    oiy.a(this.a, "content");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojc
 * JD-Core Version:    0.7.0.1
 */