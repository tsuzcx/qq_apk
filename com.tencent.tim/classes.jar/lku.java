import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class lku
{
  JSONObject jsonObject = new JSONObject();
  
  public lku A(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.N(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku B(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.O(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku C(BaseArticleInfo paramBaseArticleInfo)
  {
    llu.a(this.jsonObject, paramBaseArticleInfo);
    return this;
  }
  
  public lku D(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.R(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku E(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mChannelID == 0L)) {
      return this;
    }
    llu.X(this.jsonObject);
    return this;
  }
  
  public JSONObject E()
  {
    return this.jsonObject;
  }
  
  public lku F(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.v(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku G(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.S(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku H(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.T(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku I(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.V(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku J(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.W(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku K(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.X(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku L(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.U(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku M(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.z(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku N(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.A(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku O(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.L(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku P(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.af(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku Q(BaseArticleInfo paramBaseArticleInfo)
  {
    llu.al(paramBaseArticleInfo, this.jsonObject);
    llu.ag(paramBaseArticleInfo, this.jsonObject);
    llu.ah(paramBaseArticleInfo, this.jsonObject);
    llu.ai(paramBaseArticleInfo, this.jsonObject);
    llu.aj(paramBaseArticleInfo, this.jsonObject);
    llu.ak(paramBaseArticleInfo, this.jsonObject);
    llu.an(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    J(paramBaseArticleInfo);
    K(paramBaseArticleInfo);
    return this;
  }
  
  public lku a(BaseArticleInfo paramBaseArticleInfo, long paramLong)
    throws JSONException
  {
    llu.a(paramBaseArticleInfo, this.jsonObject, Long.valueOf(paramLong));
    return this;
  }
  
  public lku a(BaseArticleInfo paramBaseArticleInfo, String paramString)
    throws JSONException
  {
    llu.b(paramBaseArticleInfo, this.jsonObject, paramString);
    return this;
  }
  
  public lku a(String paramString)
    throws JSONException
  {
    this.jsonObject.put("style_ID", paramString);
    return this;
  }
  
  public lku a(String paramString, Object paramObject)
    throws JSONException
  {
    this.jsonObject.put(paramString, paramObject);
    return this;
  }
  
  public lku b(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.q(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku b(BaseArticleInfo paramBaseArticleInfo, String paramString)
    throws JSONException
  {
    llu.a(paramBaseArticleInfo, this.jsonObject, paramString);
    return this;
  }
  
  public lku c(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.x(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku c(BaseArticleInfo paramBaseArticleInfo, String paramString)
    throws JSONException
  {
    llu.c(paramBaseArticleInfo, this.jsonObject, paramString);
    return this;
  }
  
  public lku d(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.r(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku e(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.s(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku f(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.t(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku g(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.u(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku h(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.P(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku i(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.Q(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku j(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.a(paramBaseArticleInfo, this.jsonObject, "id_dislike_button");
    return this;
  }
  
  public lku k(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.k(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku l(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.l(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku m(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.G(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku n(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.E(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku o(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.H(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku p(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.I(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku q(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.F(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku r(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.m(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku s(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.n(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku t(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.o(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku u(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.p(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku v(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.C(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku w(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.D(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku x(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.J(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku y(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.K(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
  
  public lku z(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    llu.M(paramBaseArticleInfo, this.jsonObject);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lku
 * JD-Core Version:    0.7.0.1
 */