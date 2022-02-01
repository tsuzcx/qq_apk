package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.Origin;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class CSS
  implements ChromeDevtoolsDomain
{
  private final Document mDocument;
  private final ObjectMapper mObjectMapper;
  private final ChromePeerManager mPeerManager;
  
  public CSS(Document paramDocument)
  {
    this.mDocument = ((Document)Util.throwIfNull(paramDocument));
    this.mObjectMapper = new ObjectMapper();
    this.mPeerManager = new ChromePeerManager();
    this.mPeerManager.setListener(new PeerManagerListener(null));
  }
  
  private RuleMatch getAccessibilityRuleMatch()
  {
    Object localObject = new Selector(null);
    ((Selector)localObject).value = "Accessibility Properties";
    CSSRule localCSSRule = new CSSRule(null);
    localCSSRule.origin = Origin.REGULAR;
    localCSSRule.selectorList = new SelectorList(null);
    localCSSRule.selectorList.selectors = ListUtil.newImmutableList(localObject);
    localCSSRule.style = new CSSStyle(null);
    localCSSRule.style.cssProperties = new ArrayList();
    localCSSRule.style.shorthandEntries = Collections.emptyList();
    localObject = new RuleMatch(null);
    ((RuleMatch)localObject).matchingSelectors = ListUtil.newImmutableList(Integer.valueOf(0));
    ((RuleMatch)localObject).rule = localCSSRule;
    return localObject;
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getComputedStyleForNode(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (GetComputedStyleForNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, GetComputedStyleForNodeRequest.class);
    paramJSONObject = new GetComputedStyleForNodeResult(null);
    paramJSONObject.computedStyle = new ArrayList();
    this.mDocument.postAndWait(new CSS.1(this, paramJsonRpcPeer, paramJSONObject));
    return paramJSONObject;
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getMatchedStylesForNode(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (GetMatchedStylesForNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, GetMatchedStylesForNodeRequest.class);
    paramJSONObject = new GetMatchedStylesForNodeResult(null);
    RuleMatch localRuleMatch1 = new RuleMatch(null);
    RuleMatch localRuleMatch2 = getAccessibilityRuleMatch();
    paramJSONObject.matchedCSSRules = ListUtil.newImmutableList(localRuleMatch1, localRuleMatch2);
    localRuleMatch1.matchingSelectors = ListUtil.newImmutableList(Integer.valueOf(0));
    Selector localSelector = new Selector(null);
    localSelector.value = "<this_element>";
    CSSRule localCSSRule = new CSSRule(null);
    localCSSRule.origin = Origin.REGULAR;
    localCSSRule.selectorList = new SelectorList(null);
    localCSSRule.selectorList.selectors = ListUtil.newImmutableList(localSelector);
    localCSSRule.style = new CSSStyle(null);
    localCSSRule.style.cssProperties = new ArrayList();
    localRuleMatch1.rule = localCSSRule;
    localCSSRule.style.shorthandEntries = Collections.emptyList();
    this.mDocument.postAndWait(new CSS.2(this, paramJsonRpcPeer, localRuleMatch1, localRuleMatch2));
    paramJSONObject.inherited = Collections.emptyList();
    paramJSONObject.pseudoElements = Collections.emptyList();
    return paramJSONObject;
  }
  
  static class CSSComputedStyleProperty
  {
    @JsonProperty(required=true)
    public String name;
    @JsonProperty(required=true)
    public String value;
  }
  
  static class CSSProperty
  {
    @JsonProperty
    public Boolean disabled;
    @JsonProperty
    public Boolean implicit;
    @JsonProperty
    public Boolean important;
    @JsonProperty(required=true)
    public String name;
    @JsonProperty
    public Boolean parsedOk;
    @JsonProperty
    public CSS.SourceRange range;
    @JsonProperty
    public String text;
    @JsonProperty(required=true)
    public String value;
  }
  
  static class CSSRule
  {
    @JsonProperty
    public Origin origin;
    @JsonProperty(required=true)
    public CSS.SelectorList selectorList;
    @JsonProperty
    public CSS.CSSStyle style;
    @JsonProperty
    public String styleSheetId;
  }
  
  static class CSSStyle
  {
    @JsonProperty(required=true)
    public List<CSS.CSSProperty> cssProperties;
    @JsonProperty
    public String cssText;
    @JsonProperty
    public CSS.SourceRange range;
    @JsonProperty
    public List<CSS.ShorthandEntry> shorthandEntries;
    @JsonProperty
    public String styleSheetId;
  }
  
  static class GetComputedStyleForNodeRequest
  {
    @JsonProperty(required=true)
    public int nodeId;
  }
  
  static class GetComputedStyleForNodeResult
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public List<CSS.CSSComputedStyleProperty> computedStyle;
  }
  
  static class GetMatchedStylesForNodeRequest
    implements JsonRpcResult
  {
    @JsonProperty
    public Boolean excludeInherited;
    @JsonProperty
    public Boolean excludePseudo;
    @JsonProperty(required=true)
    public int nodeId;
  }
  
  static class GetMatchedStylesForNodeResult
    implements JsonRpcResult
  {
    @JsonProperty
    public List<CSS.InheritedStyleEntry> inherited;
    @JsonProperty
    public List<CSS.RuleMatch> matchedCSSRules;
    @JsonProperty
    public List<CSS.PseudoIdMatches> pseudoElements;
  }
  
  static class InheritedStyleEntry
  {
    @JsonProperty(required=true)
    public CSS.CSSStyle inlineStyle;
    @JsonProperty(required=true)
    public List<CSS.RuleMatch> matchedCSSRules;
  }
  
  final class PeerManagerListener
    extends PeersRegisteredListener
  {
    private PeerManagerListener() {}
    
    public void onFirstPeerRegistered()
    {
      try
      {
        CSS.this.mDocument.addRef();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void onLastPeerUnregistered()
    {
      try
      {
        CSS.this.mDocument.release();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  static class PseudoIdMatches
  {
    @JsonProperty(required=true)
    public List<CSS.RuleMatch> matches = new ArrayList();
    @JsonProperty(required=true)
    public int pseudoId;
  }
  
  static class RuleMatch
  {
    @JsonProperty
    public List<Integer> matchingSelectors;
    @JsonProperty
    public CSS.CSSRule rule;
  }
  
  static class Selector
  {
    @JsonProperty
    public CSS.SourceRange range;
    @JsonProperty(required=true)
    public String value;
  }
  
  static class SelectorList
  {
    @JsonProperty
    public List<CSS.Selector> selectors;
    @JsonProperty
    public String text;
  }
  
  static class ShorthandEntry
  {
    @JsonProperty
    public Boolean imporant;
    @JsonProperty(required=true)
    public String name;
    @JsonProperty(required=true)
    public String value;
  }
  
  static class SourceRange
  {
    @JsonProperty(required=true)
    public int endColumn;
    @JsonProperty(required=true)
    public int endLine;
    @JsonProperty(required=true)
    public int startColumn;
    @JsonProperty(required=true)
    public int startLine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.CSS
 * JD-Core Version:    0.7.0.1
 */