package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.AllElementTest;
import com.hp.hpl.sparta.xpath.AttrCompareExpr;
import com.hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.hp.hpl.sparta.xpath.AttrExistsExpr;
import com.hp.hpl.sparta.xpath.AttrExpr;
import com.hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.hp.hpl.sparta.xpath.AttrLessExpr;
import com.hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.hp.hpl.sparta.xpath.AttrRelationalExpr;
import com.hp.hpl.sparta.xpath.AttrTest;
import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.ElementTest;
import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.ParentNodeTest;
import com.hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.hp.hpl.sparta.xpath.Step;
import com.hp.hpl.sparta.xpath.TextCompareExpr;
import com.hp.hpl.sparta.xpath.TextEqualsExpr;
import com.hp.hpl.sparta.xpath.TextExistsExpr;
import com.hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.hp.hpl.sparta.xpath.TextTest;
import com.hp.hpl.sparta.xpath.ThisNodeTest;
import com.hp.hpl.sparta.xpath.TrueExpr;
import com.hp.hpl.sparta.xpath.Visitor;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;
import java.util.Enumeration;
import java.util.Vector;

class XPathVisitor
  implements Visitor
{
  private static final Boolean FALSE = new Boolean(false);
  private static final Boolean TRUE = new Boolean(true);
  private Node contextNode_;
  private final BooleanStack exprStack_ = new BooleanStack(null);
  private boolean multiLevel_;
  private Object node_ = null;
  private Vector nodelistFiltered_ = new Vector();
  private final NodeListWithPosition nodelistRaw_ = new NodeListWithPosition();
  private Enumeration nodesetIterator_ = null;
  private XPath xpath_;
  
  public XPathVisitor(Document paramDocument, XPath paramXPath)
    throws XPathException
  {
    this(paramXPath, paramDocument);
  }
  
  public XPathVisitor(Element paramElement, XPath paramXPath)
    throws XPathException
  {
    this(paramXPath, paramElement);
    if (paramXPath.isAbsolute()) {
      throw new XPathException(paramXPath, "Cannot use element as context node for absolute xpath");
    }
  }
  
  private XPathVisitor(XPath paramXPath, Node paramNode)
    throws XPathException
  {
    this.xpath_ = paramXPath;
    this.contextNode_ = paramNode;
    this.nodelistFiltered_ = new Vector(1);
    this.nodelistFiltered_.addElement(this.contextNode_);
    paramXPath = paramXPath.getSteps();
    for (;;)
    {
      if (!paramXPath.hasMoreElements()) {
        return;
      }
      paramNode = (Step)paramXPath.nextElement();
      this.multiLevel_ = paramNode.isMultiLevel();
      this.nodesetIterator_ = null;
      paramNode.getNodeTest().accept(this);
      this.nodesetIterator_ = this.nodelistRaw_.iterator();
      this.nodelistFiltered_.removeAllElements();
      paramNode = paramNode.getPredicate();
      while (this.nodesetIterator_.hasMoreElements())
      {
        this.node_ = this.nodesetIterator_.nextElement();
        paramNode.accept(this);
        if (this.exprStack_.pop().booleanValue()) {
          this.nodelistFiltered_.addElement(this.node_);
        }
      }
    }
  }
  
  private void accumulateElements(Document paramDocument)
  {
    paramDocument = paramDocument.getDocumentElement();
    this.nodelistRaw_.add(paramDocument, 1);
    if (this.multiLevel_) {
      accumulateElements(paramDocument);
    }
  }
  
  private void accumulateElements(Element paramElement)
  {
    int i = 0;
    paramElement = paramElement.getFirstChild();
    for (;;)
    {
      if (paramElement == null) {
        return;
      }
      int j = i;
      if ((paramElement instanceof Element))
      {
        NodeListWithPosition localNodeListWithPosition = this.nodelistRaw_;
        j = i + 1;
        localNodeListWithPosition.add(paramElement, j);
        if (this.multiLevel_) {
          accumulateElements((Element)paramElement);
        }
      }
      paramElement = paramElement.getNextSibling();
      i = j;
    }
  }
  
  private void accumulateMatchingElements(Document paramDocument, String paramString)
  {
    paramDocument = paramDocument.getDocumentElement();
    if (paramDocument == null) {}
    do
    {
      return;
      if (paramDocument.getTagName() == paramString) {
        this.nodelistRaw_.add(paramDocument, 1);
      }
    } while (!this.multiLevel_);
    accumulateMatchingElements(paramDocument, paramString);
  }
  
  private void accumulateMatchingElements(Element paramElement, String paramString)
  {
    int i = 0;
    paramElement = paramElement.getFirstChild();
    for (;;)
    {
      if (paramElement == null) {
        return;
      }
      int k = i;
      if ((paramElement instanceof Element))
      {
        Element localElement = (Element)paramElement;
        int j = i;
        if (localElement.getTagName() == paramString)
        {
          NodeListWithPosition localNodeListWithPosition = this.nodelistRaw_;
          j = i + 1;
          localNodeListWithPosition.add(localElement, j);
        }
        k = j;
        if (this.multiLevel_)
        {
          accumulateMatchingElements(localElement, paramString);
          k = j;
        }
      }
      paramElement = paramElement.getNextSibling();
      i = k;
    }
  }
  
  public Element getFirstResultElement()
  {
    if (this.nodelistFiltered_.size() == 0) {
      return null;
    }
    return (Element)this.nodelistFiltered_.elementAt(0);
  }
  
  public String getFirstResultString()
  {
    if (this.nodelistFiltered_.size() == 0) {
      return null;
    }
    return this.nodelistFiltered_.elementAt(0).toString();
  }
  
  public Enumeration getResultEnumeration()
  {
    return this.nodelistFiltered_.elements();
  }
  
  public void visit(AllElementTest paramAllElementTest)
  {
    paramAllElementTest = this.nodelistFiltered_;
    this.nodelistRaw_.removeAllElements();
    paramAllElementTest = paramAllElementTest.elements();
    for (;;)
    {
      if (!paramAllElementTest.hasMoreElements()) {
        return;
      }
      Object localObject = paramAllElementTest.nextElement();
      if ((localObject instanceof Element)) {
        accumulateElements((Element)localObject);
      } else if ((localObject instanceof Document)) {
        accumulateElements((Document)localObject);
      }
    }
  }
  
  public void visit(AttrEqualsExpr paramAttrEqualsExpr)
    throws XPathException
  {
    if (!(this.node_ instanceof Element)) {
      throw new XPathException(this.xpath_, "Cannot test attribute of document");
    }
    Object localObject = ((Element)this.node_).getAttribute(paramAttrEqualsExpr.getAttrName());
    boolean bool = paramAttrEqualsExpr.getAttrValue().equals(localObject);
    localObject = this.exprStack_;
    if (bool) {}
    for (paramAttrEqualsExpr = TRUE;; paramAttrEqualsExpr = FALSE)
    {
      ((BooleanStack)localObject).push(paramAttrEqualsExpr);
      return;
    }
  }
  
  public void visit(AttrExistsExpr paramAttrExistsExpr)
    throws XPathException
  {
    if (!(this.node_ instanceof Element)) {
      throw new XPathException(this.xpath_, "Cannot test attribute of document");
    }
    paramAttrExistsExpr = ((Element)this.node_).getAttribute(paramAttrExistsExpr.getAttrName());
    int i;
    BooleanStack localBooleanStack;
    if ((paramAttrExistsExpr != null) && (paramAttrExistsExpr.length() > 0))
    {
      i = 1;
      localBooleanStack = this.exprStack_;
      if (i == 0) {
        break label76;
      }
    }
    label76:
    for (paramAttrExistsExpr = TRUE;; paramAttrExistsExpr = FALSE)
    {
      localBooleanStack.push(paramAttrExistsExpr);
      return;
      i = 0;
      break;
    }
  }
  
  public void visit(AttrGreaterExpr paramAttrGreaterExpr)
    throws XPathException
  {
    if (!(this.node_ instanceof Element)) {
      throw new XPathException(this.xpath_, "Cannot test attribute of document");
    }
    int i;
    BooleanStack localBooleanStack;
    if (Long.parseLong(((Element)this.node_).getAttribute(paramAttrGreaterExpr.getAttrName())) > paramAttrGreaterExpr.getAttrValue())
    {
      i = 1;
      localBooleanStack = this.exprStack_;
      if (i == 0) {
        break label76;
      }
    }
    label76:
    for (paramAttrGreaterExpr = TRUE;; paramAttrGreaterExpr = FALSE)
    {
      localBooleanStack.push(paramAttrGreaterExpr);
      return;
      i = 0;
      break;
    }
  }
  
  public void visit(AttrLessExpr paramAttrLessExpr)
    throws XPathException
  {
    if (!(this.node_ instanceof Element)) {
      throw new XPathException(this.xpath_, "Cannot test attribute of document");
    }
    int i;
    BooleanStack localBooleanStack;
    if (Long.parseLong(((Element)this.node_).getAttribute(paramAttrLessExpr.getAttrName())) < paramAttrLessExpr.getAttrValue())
    {
      i = 1;
      localBooleanStack = this.exprStack_;
      if (i == 0) {
        break label76;
      }
    }
    label76:
    for (paramAttrLessExpr = TRUE;; paramAttrLessExpr = FALSE)
    {
      localBooleanStack.push(paramAttrLessExpr);
      return;
      i = 0;
      break;
    }
  }
  
  public void visit(AttrNotEqualsExpr paramAttrNotEqualsExpr)
    throws XPathException
  {
    if (!(this.node_ instanceof Element)) {
      throw new XPathException(this.xpath_, "Cannot test attribute of document");
    }
    Object localObject = ((Element)this.node_).getAttribute(paramAttrNotEqualsExpr.getAttrName());
    int i;
    if (!paramAttrNotEqualsExpr.getAttrValue().equals(localObject))
    {
      i = 1;
      localObject = this.exprStack_;
      if (i == 0) {
        break label76;
      }
    }
    label76:
    for (paramAttrNotEqualsExpr = TRUE;; paramAttrNotEqualsExpr = FALSE)
    {
      ((BooleanStack)localObject).push(paramAttrNotEqualsExpr);
      return;
      i = 0;
      break;
    }
  }
  
  public void visit(AttrTest paramAttrTest)
  {
    Object localObject1 = this.nodelistFiltered_;
    this.nodelistRaw_.removeAllElements();
    localObject1 = ((Vector)localObject1).elements();
    for (;;)
    {
      if (!((Enumeration)localObject1).hasMoreElements()) {
        return;
      }
      Object localObject2 = (Node)((Enumeration)localObject1).nextElement();
      if ((localObject2 instanceof Element))
      {
        localObject2 = ((Element)localObject2).getAttribute(paramAttrTest.getAttrName());
        if (localObject2 != null) {
          this.nodelistRaw_.add((String)localObject2);
        }
      }
    }
  }
  
  public void visit(ElementTest paramElementTest)
  {
    paramElementTest = paramElementTest.getTagName();
    Vector localVector = this.nodelistFiltered_;
    int j = localVector.size();
    this.nodelistRaw_.removeAllElements();
    int i = 0;
    if (i >= j) {
      return;
    }
    Object localObject = localVector.elementAt(i);
    if ((localObject instanceof Element)) {
      accumulateMatchingElements((Element)localObject, paramElementTest);
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localObject instanceof Document)) {
        accumulateMatchingElements((Document)localObject, paramElementTest);
      }
    }
  }
  
  public void visit(ParentNodeTest paramParentNodeTest)
    throws XPathException
  {
    this.nodelistRaw_.removeAllElements();
    paramParentNodeTest = this.contextNode_.getParentNode();
    if (paramParentNodeTest == null) {
      throw new XPathException(this.xpath_, "Illegal attempt to apply \"..\" to node with no parent.");
    }
    this.nodelistRaw_.add(paramParentNodeTest, 1);
  }
  
  public void visit(PositionEqualsExpr paramPositionEqualsExpr)
    throws XPathException
  {
    if (!(this.node_ instanceof Element)) {
      throw new XPathException(this.xpath_, "Cannot test position of document");
    }
    Object localObject = (Element)this.node_;
    int i;
    if (this.nodelistRaw_.position((Node)localObject) == paramPositionEqualsExpr.getPosition())
    {
      i = 1;
      localObject = this.exprStack_;
      if (i == 0) {
        break label74;
      }
    }
    label74:
    for (paramPositionEqualsExpr = TRUE;; paramPositionEqualsExpr = FALSE)
    {
      ((BooleanStack)localObject).push(paramPositionEqualsExpr);
      return;
      i = 0;
      break;
    }
  }
  
  public void visit(TextEqualsExpr paramTextEqualsExpr)
    throws XPathException
  {
    if (!(this.node_ instanceof Element)) {
      throw new XPathException(this.xpath_, "Cannot test attribute of document");
    }
    for (Node localNode = ((Element)this.node_).getFirstChild();; localNode = localNode.getNextSibling())
    {
      if (localNode == null)
      {
        this.exprStack_.push(FALSE);
        return;
      }
      if (((localNode instanceof Text)) && (((Text)localNode).getData().equals(paramTextEqualsExpr.getValue())))
      {
        this.exprStack_.push(TRUE);
        return;
      }
    }
  }
  
  public void visit(TextExistsExpr paramTextExistsExpr)
    throws XPathException
  {
    if (!(this.node_ instanceof Element)) {
      throw new XPathException(this.xpath_, "Cannot test attribute of document");
    }
    for (paramTextExistsExpr = ((Element)this.node_).getFirstChild();; paramTextExistsExpr = paramTextExistsExpr.getNextSibling())
    {
      if (paramTextExistsExpr == null)
      {
        this.exprStack_.push(FALSE);
        return;
      }
      if ((paramTextExistsExpr instanceof Text))
      {
        this.exprStack_.push(TRUE);
        return;
      }
    }
  }
  
  public void visit(TextNotEqualsExpr paramTextNotEqualsExpr)
    throws XPathException
  {
    if (!(this.node_ instanceof Element)) {
      throw new XPathException(this.xpath_, "Cannot test attribute of document");
    }
    for (Node localNode = ((Element)this.node_).getFirstChild();; localNode = localNode.getNextSibling())
    {
      if (localNode == null)
      {
        this.exprStack_.push(FALSE);
        return;
      }
      if (((localNode instanceof Text)) && (!((Text)localNode).getData().equals(paramTextNotEqualsExpr.getValue())))
      {
        this.exprStack_.push(TRUE);
        return;
      }
    }
  }
  
  public void visit(TextTest paramTextTest)
  {
    paramTextTest = this.nodelistFiltered_;
    this.nodelistRaw_.removeAllElements();
    Enumeration localEnumeration = paramTextTest.elements();
    for (;;)
    {
      if (!localEnumeration.hasMoreElements()) {
        return;
      }
      paramTextTest = localEnumeration.nextElement();
      if ((paramTextTest instanceof Element)) {
        for (paramTextTest = ((Element)paramTextTest).getFirstChild(); paramTextTest != null; paramTextTest = paramTextTest.getNextSibling()) {
          if ((paramTextTest instanceof Text)) {
            this.nodelistRaw_.add(((Text)paramTextTest).getData());
          }
        }
      }
    }
  }
  
  public void visit(ThisNodeTest paramThisNodeTest)
  {
    this.nodelistRaw_.removeAllElements();
    this.nodelistRaw_.add(this.contextNode_, 1);
  }
  
  public void visit(TrueExpr paramTrueExpr)
  {
    this.exprStack_.push(TRUE);
  }
  
  static class BooleanStack
  {
    private Item top_ = null;
    
    private BooleanStack() {}
    
    BooleanStack(XPathVisitor.1 param1)
    {
      this();
    }
    
    Boolean pop()
    {
      Boolean localBoolean = this.top_.bool;
      this.top_ = this.top_.prev;
      return localBoolean;
    }
    
    void push(Boolean paramBoolean)
    {
      this.top_ = new Item(paramBoolean, this.top_);
    }
    
    static class Item
    {
      final Boolean bool;
      final Item prev;
      
      Item(Boolean paramBoolean, Item paramItem)
      {
        this.bool = paramBoolean;
        this.prev = paramItem;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.XPathVisitor
 * JD-Core Version:    0.7.0.1
 */