/* empty css             */import{i as W,a as ze,b as se,r as Ce,g as Te,c as we,d as de,m as he,e as oe,f as le,h as me,j as Se,s as Oe,u as ye,k as _e,l as Ne,n as S,o as $e,p as Re,q as x,w as fe,t as ke,v as be,x as E,y as re,z as v,A as C,B as m,C as k,D as s,E as ve,F as Ae,G as N,H as V,I as Be,J as O,K as ie,L as Me,M as Ve,N as We,O as Xe,P as Ie,Q as Ye,R as De,S as Fe,T as He,U as Pe,V as ae,W as xe,X as je,_ as Ee,Y as K,Z as j,$ as Ke,a0 as Le,a1 as Ze,a2 as qe,a3 as Ge,a4 as Ue,a5 as Je,a6 as Qe,a7 as et,a8 as tt,a9 as nt}from"./index-e5402df2.js";import{u as at}from"./index-ff326efe.js";const st=(e,r)=>{if(!W||!e||!r)return!1;const t=e.getBoundingClientRect();let o;return r instanceof Element?o=r.getBoundingClientRect():o={top:0,right:window.innerWidth,bottom:window.innerHeight,left:0},t.top<o.bottom&&t.bottom>o.top&&t.right>o.left&&t.left<o.right};var ot=/\s/;function rt(e){for(var r=e.length;r--&&ot.test(e.charAt(r)););return r}var it=/^\s+/;function lt(e){return e&&e.slice(0,rt(e)+1).replace(it,"")}var pe=0/0,ct=/^[-+]0x[0-9a-f]+$/i,ut=/^0b[01]+$/i,dt=/^0o[0-7]+$/i,ft=parseInt;function ge(e){if(typeof e=="number")return e;if(ze(e))return pe;if(se(e)){var r=typeof e.valueOf=="function"?e.valueOf():e;e=se(r)?r+"":r}if(typeof e!="string")return e===0?e:+e;e=lt(e);var t=ut.test(e);return t||dt.test(e)?ft(e.slice(2),t?2:8):ct.test(e)?pe:+e}var vt=function(){return Ce.Date.now()};const ce=vt;var mt="Expected a function",pt=Math.max,gt=Math.min;function wt(e,r,t){var o,u,b,l,w,_,I=0,L=!1,h=!1,p=!0;if(typeof e!="function")throw new TypeError(mt);r=ge(r)||0,se(t)&&(L=!!t.leading,h="maxWait"in t,b=h?pt(ge(t.maxWait)||0,r):b,p="trailing"in t?!!t.trailing:p);function g(c){var y=o,A=u;return o=u=void 0,I=c,l=e.apply(A,y),l}function d(c){return I=c,w=setTimeout(R,r),L?g(c):l}function X(c){var y=c-_,A=c-I,H=r-y;return h?gt(H,b-A):H}function $(c){var y=c-_,A=c-I;return _===void 0||y>=r||y<0||h&&A>=b}function R(){var c=ce();if($(c))return F(c);w=setTimeout(R,X(c))}function F(c){return w=void 0,p&&o?g(c):(o=u=void 0,l)}function Z(){w!==void 0&&clearTimeout(w),I=0,o=_=u=w=void 0}function Y(){return w===void 0?l:F(ce())}function D(){var c=ce(),y=$(c);if(o=arguments,u=this,_=c,y){if(w===void 0)return d(_);if(h)return clearTimeout(w),w=setTimeout(R,r),g(_)}return w===void 0&&(w=setTimeout(R,r)),l}return D.cancel=Z,D.flush=Y,D}var ht="Expected a function";function ue(e,r,t){var o=!0,u=!0;if(typeof e!="function")throw new TypeError(ht);return se(t)&&(o="leading"in t?!!t.leading:o,u="trailing"in t?!!t.trailing:u),wt(e,r,{leading:o,maxWait:r,trailing:u})}const yt=(e,r)=>{if(!W)return!1;const t={undefined:"overflow",true:"overflow-y",false:"overflow-x"}[String(r)],o=Te(e,t);return["scroll","auto","overlay"].some(u=>o.includes(u))},_t=(e,r)=>{if(!W)return;let t=e;for(;t;){if([window,document,document.documentElement].includes(t))return window;if(yt(t,r))return t;t=t.parentNode}return t},kt=we({urlList:{type:de(Array),default:()=>he([])},zIndex:{type:Number},initialIndex:{type:Number,default:0},infinite:{type:Boolean,default:!0},hideOnClickModal:Boolean,teleported:Boolean,closeOnPressEscape:{type:Boolean,default:!0},zoomRate:{type:Number,default:1.2}}),bt={close:()=>!0,switch:e=>oe(e),rotate:e=>oe(e)},It=["src"],xt=le({name:"ElImageViewer"}),Et=le({...xt,props:kt,emits:bt,setup(e,{expose:r,emit:t}){const o=e,u={CONTAIN:{name:"contain",icon:me(Se)},ORIGINAL:{name:"original",icon:me(Oe)}},{t:b}=ye(),l=_e("image-viewer"),{nextZIndex:w}=Ne(),_=S(),I=S([]),L=$e(),h=S(!0),p=S(o.initialIndex),g=Re(u.CONTAIN),d=S({scale:1,deg:0,offsetX:0,offsetY:0,enableTransition:!1}),X=x(()=>{const{urlList:n}=o;return n.length<=1}),$=x(()=>p.value===0),R=x(()=>p.value===o.urlList.length-1),F=x(()=>o.urlList[p.value]),Z=x(()=>[l.e("btn"),l.e("prev"),l.is("disabled",!o.infinite&&$.value)]),Y=x(()=>[l.e("btn"),l.e("next"),l.is("disabled",!o.infinite&&R.value)]),D=x(()=>{const{scale:n,deg:i,offsetX:f,offsetY:z,enableTransition:B}=d.value;let T=f/n,M=z/n;switch(i%360){case 90:case-270:[T,M]=[M,-T];break;case 180:case-180:[T,M]=[-T,-M];break;case 270:case-90:[T,M]=[-M,T];break}const P={transform:`scale(${n}) rotate(${i}deg) translate(${T}px, ${M}px)`,transition:B?"transform .3s":""};return g.value.name===u.CONTAIN.name&&(P.maxWidth=P.maxHeight="100%"),P}),c=x(()=>oe(o.zIndex)?o.zIndex:w());function y(){H(),t("close")}function A(){const n=ue(f=>{switch(f.code){case j.esc:o.closeOnPressEscape&&y();break;case j.space:ee();break;case j.left:te();break;case j.up:a("zoomIn");break;case j.right:ne();break;case j.down:a("zoomOut");break}}),i=ue(f=>{const z=f.deltaY||f.deltaX;a(z<0?"zoomIn":"zoomOut",{zoomRate:o.zoomRate,enableTransition:!1})});L.run(()=>{K(document,"keydown",n),K(document,"wheel",i)})}function H(){L.stop()}function U(){h.value=!1}function J(n){h.value=!1,n.target.alt=b("el.image.error")}function Q(n){if(h.value||n.button!==0||!_.value)return;d.value.enableTransition=!1;const{offsetX:i,offsetY:f}=d.value,z=n.pageX,B=n.pageY,T=ue(P=>{d.value={...d.value,offsetX:i+P.pageX-z,offsetY:f+P.pageY-B}}),M=K(document,"mousemove",T);K(document,"mouseup",()=>{M()}),n.preventDefault()}function q(){d.value={scale:1,deg:0,offsetX:0,offsetY:0,enableTransition:!1}}function ee(){if(h.value)return;const n=Ke(u),i=Object.values(u),f=g.value.name,B=(i.findIndex(T=>T.name===f)+1)%n.length;g.value=u[n[B]],q()}function G(n){const i=o.urlList.length;p.value=(n+i)%i}function te(){$.value&&!o.infinite||G(p.value-1)}function ne(){R.value&&!o.infinite||G(p.value+1)}function a(n,i={}){if(h.value)return;const{zoomRate:f,rotateDeg:z,enableTransition:B}={zoomRate:o.zoomRate,rotateDeg:90,enableTransition:!0,...i};switch(n){case"zoomOut":d.value.scale>.2&&(d.value.scale=Number.parseFloat((d.value.scale/f).toFixed(3)));break;case"zoomIn":d.value.scale<7&&(d.value.scale=Number.parseFloat((d.value.scale*f).toFixed(3)));break;case"clockwise":d.value.deg+=z,t("rotate",d.value.deg);break;case"anticlockwise":d.value.deg-=z,t("rotate",d.value.deg);break}d.value.enableTransition=B}return fe(F,()=>{ke(()=>{const n=I.value[0];n!=null&&n.complete||(h.value=!0)})}),fe(p,n=>{q(),t("switch",n)}),be(()=>{var n,i;A(),(i=(n=_.value)==null?void 0:n.focus)==null||i.call(n)}),r({setActiveItem:G}),(n,i)=>(E(),re(je,{to:"body",disabled:!n.teleported},[v(xe,{name:"viewer-fade",appear:""},{default:C(()=>[m("div",{ref_key:"wrapper",ref:_,tabindex:-1,class:k(s(l).e("wrapper")),style:ve({zIndex:s(c)})},[m("div",{class:k(s(l).e("mask")),onClick:i[0]||(i[0]=Ae(f=>n.hideOnClickModal&&y(),["self"]))},null,2),N(" CLOSE "),m("span",{class:k([s(l).e("btn"),s(l).e("close")]),onClick:y},[v(s(V),null,{default:C(()=>[v(s(Be))]),_:1})],2),N(" ARROW "),s(X)?N("v-if",!0):(E(),O(ie,{key:0},[m("span",{class:k(s(Z)),onClick:te},[v(s(V),null,{default:C(()=>[v(s(Me))]),_:1})],2),m("span",{class:k(s(Y)),onClick:ne},[v(s(V),null,{default:C(()=>[v(s(Ve))]),_:1})],2)],64)),N(" ACTIONS "),m("div",{class:k([s(l).e("btn"),s(l).e("actions")])},[m("div",{class:k(s(l).e("actions__inner"))},[v(s(V),{onClick:i[1]||(i[1]=f=>a("zoomOut"))},{default:C(()=>[v(s(We))]),_:1}),v(s(V),{onClick:i[2]||(i[2]=f=>a("zoomIn"))},{default:C(()=>[v(s(Xe))]),_:1}),m("i",{class:k(s(l).e("actions__divider"))},null,2),v(s(V),{onClick:ee},{default:C(()=>[(E(),re(Ie(s(g).icon)))]),_:1}),m("i",{class:k(s(l).e("actions__divider"))},null,2),v(s(V),{onClick:i[3]||(i[3]=f=>a("anticlockwise"))},{default:C(()=>[v(s(Ye))]),_:1}),v(s(V),{onClick:i[4]||(i[4]=f=>a("clockwise"))},{default:C(()=>[v(s(De))]),_:1})],2)],2),N(" CANVAS "),m("div",{class:k(s(l).e("canvas"))},[(E(!0),O(ie,null,Fe(n.urlList,(f,z)=>He((E(),O("img",{ref_for:!0,ref:B=>I.value[z]=B,key:f,src:f,style:ve(s(D)),class:k(s(l).e("img")),onLoad:U,onError:J,onMousedown:Q},null,46,It)),[[Pe,z===p.value]])),128))],2),ae(n.$slots,"default")],6)]),_:3})],8,["disabled"]))}});var Lt=Ee(Et,[["__file","/home/runner/work/element-plus/element-plus/packages/components/image-viewer/src/image-viewer.vue"]]);const zt=Le(Lt),Ct=we({hideOnClickModal:Boolean,src:{type:String,default:""},fit:{type:String,values:["","contain","cover","fill","none","scale-down"],default:""},loading:{type:String,values:["eager","lazy"]},lazy:Boolean,scrollContainer:{type:de([String,Object])},previewSrcList:{type:de(Array),default:()=>he([])},previewTeleported:Boolean,zIndex:{type:Number},initialIndex:{type:Number,default:0},infinite:{type:Boolean,default:!0},closeOnPressEscape:{type:Boolean,default:!0},zoomRate:{type:Number,default:1.2}}),Tt={load:e=>e instanceof Event,error:e=>e instanceof Event,switch:e=>oe(e),close:()=>!0,show:()=>!0},St=["src","loading"],Ot={key:0},Nt=le({name:"ElImage",inheritAttrs:!1}),$t=le({...Nt,props:Ct,emits:Tt,setup(e,{emit:r}){const t=e;let o="";const{t:u}=ye(),b=_e("image"),l=Ze(),w=at(),_=S(),I=S(!1),L=S(!0),h=S(!1),p=S(),g=S(),d=W&&"loading"in HTMLImageElement.prototype;let X,$;const R=x(()=>[b.e("inner"),Y.value&&b.e("preview"),L.value&&b.is("loading")]),F=x(()=>l.style),Z=x(()=>{const{fit:a}=t;return W&&a?{objectFit:a}:{}}),Y=x(()=>{const{previewSrcList:a}=t;return Array.isArray(a)&&a.length>0}),D=x(()=>{const{previewSrcList:a,initialIndex:n}=t;let i=n;return n>a.length-1&&(i=0),i}),c=x(()=>t.loading==="eager"?!1:!d&&t.loading==="lazy"||t.lazy),y=()=>{W&&(L.value=!0,I.value=!1,_.value=t.src)};function A(a){L.value=!1,I.value=!1,r("load",a)}function H(a){L.value=!1,I.value=!0,r("error",a)}function U(){st(p.value,g.value)&&(y(),q())}const J=qe(U,200,!0);async function Q(){var a;if(!W)return;await ke();const{scrollContainer:n}=t;Ue(n)?g.value=n:Je(n)&&n!==""?g.value=(a=document.querySelector(n))!=null?a:void 0:p.value&&(g.value=_t(p.value)),g.value&&(X=K(g,"scroll",J),setTimeout(()=>U(),100))}function q(){!W||!g.value||!J||(X==null||X(),g.value=void 0)}function ee(a){if(a.ctrlKey){if(a.deltaY<0)return a.preventDefault(),!1;if(a.deltaY>0)return a.preventDefault(),!1}}function G(){Y.value&&($=K("wheel",ee,{passive:!1}),o=document.body.style.overflow,document.body.style.overflow="hidden",h.value=!0,r("show"))}function te(){$==null||$(),document.body.style.overflow=o,h.value=!1,r("close")}function ne(a){r("switch",a)}return fe(()=>t.src,()=>{c.value?(L.value=!0,I.value=!1,q(),Q()):y()}),be(()=>{c.value?Q():y()}),(a,n)=>(E(),O("div",{ref_key:"container",ref:p,class:k([s(b).b(),a.$attrs.class]),style:ve(s(F))},[I.value?ae(a.$slots,"error",{key:0},()=>[m("div",{class:k(s(b).e("error"))},Qe(s(u)("el.image.error")),3)]):(E(),O(ie,{key:1},[_.value!==void 0?(E(),O("img",Ge({key:0},s(w),{src:_.value,loading:a.loading,style:s(Z),class:s(R),onClick:G,onLoad:A,onError:H}),null,16,St)):N("v-if",!0),L.value?(E(),O("div",{key:1,class:k(s(b).e("wrapper"))},[ae(a.$slots,"placeholder",{},()=>[m("div",{class:k(s(b).e("placeholder"))},null,2)])],2)):N("v-if",!0)],64)),s(Y)?(E(),O(ie,{key:2},[h.value?(E(),re(s(zt),{key:0,"z-index":a.zIndex,"initial-index":s(D),infinite:a.infinite,"zoom-rate":a.zoomRate,"url-list":a.previewSrcList,"hide-on-click-modal":a.hideOnClickModal,teleported:a.previewTeleported,"close-on-press-escape":a.closeOnPressEscape,onClose:te,onSwitch:ne},{default:C(()=>[a.$slots.viewer?(E(),O("div",Ot,[ae(a.$slots,"viewer")])):N("v-if",!0)]),_:3},8,["z-index","initial-index","infinite","zoom-rate","url-list","hide-on-click-modal","teleported","close-on-press-escape"])):N("v-if",!0)],64)):N("v-if",!0)],6))}});var Rt=Ee($t,[["__file","/home/runner/work/element-plus/element-plus/packages/components/image/src/image.vue"]]);const At=Le(Rt);const Bt=(e,r)=>{const t=e.__vccOpts||e;for(const[o,u]of r)t[o]=u;return t},Mt={},Vt=e=>(tt("data-v-7ce6aed8"),e=e(),nt(),e),Wt={style:{width:"100vw",height:"100vh",overflow:"hidden",display:"flex"}},Xt={style:{flex:"1"}},Yt=Vt(()=>m("div",{class:"welcome-title"},[m("div",{style:{"font-size":"30px","font-weight":"bold"}},"Welcome to Wonderland"),m("div",{style:{"margin-top":"10px"}},"Here you can discuss copy-paste techniques with Lupin III"),m("div",{style:{"margin-top":"5px"}}," Or you can engage in a conversation with the God of Java")],-1)),Dt={style:{width:"400px","background-color":"white","z-index":"1"}};function Ft(e,r){const t=At,o=et("router-view");return E(),O("div",Wt,[m("div",Xt,[v(t,{style:{width:"100%",height:"100%"},fit:"cover",src:"https://asdxz.oss-cn-beijing.aliyuncs.com/img/202309231321807.jpg"})]),Yt,m("div",Dt,[v(o,null,{default:C(({Component:u})=>[v(xe,{name:"el-fade-in-linear",mode:"out-in"},{default:C(()=>[(E(),re(Ie(u),{style:{height:"100%"}}))]),_:2},1024)]),_:1})])])}const Kt=Bt(Mt,[["render",Ft],["__scopeId","data-v-7ce6aed8"]]);export{Kt as default};
