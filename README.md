# backend
https://www.polarisoffice.com/d/2RRaX968
https://ko.wix.com/website/templates/html/online-store/books-publishers-템플릿 제작

첫페이지 구조 https://note.espriter.net/1177
<br>
간단구현 순서 https://ddingz.tistory.com/171
<br>
관리자 상품등록 전체구조 https://blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=tinatan&logNo=70165598811&parentCategoryNo=&categoryNo=23&viewDate=&isShowPopularPosts=false&from=postView
<br>
전체 회원 목록 https://florescene.tistory.com/58?category=963009
<br>
장바구니, 카테고리별 검색 https://velog.io/@jeong11/teamproject-jsp-shoppingmall-cartadmin
<br>

5-31일<br>
banner.jsp 추가, guest_login.jsp 변경

6-5일<br>
전체 파일 동기화<br>
db의 userdb에서 usertype과 이름 삭제<br>
userdb.java내용 변경<br>
회원가입 db와 연동하여 구현<br>
book등록에서 decrip을 descript로 수정<br>
로그인과 세션구현(세션은 제대로 동작하지 않는 것 같지만 로그인 되어있음)
<br>
6-8일<br>
loginproc.jsp에서 에러날때 loginerror.jsp로 가게끔 설정
<br><hr>
6-13일<br>
파일 동기화<br>
db변경(book테이블의 bookid, userdb테이블의 id를 cart 테이블의foreign key로 설정)<br>
create table userdb( id varchar(10) primary key not null, pw varchar(10) not null, call varchar(20), address varchar(50), email varchar(20) );<br>
create table cart(cartid int not null primary key auto_increment, bookname varchar(30) not null, bookwriter varchar(30) not null, bookcount int not null, totalprice int not null, id varchar(20));
alter table cart<br>
add foreign key (bookid)<br>
references book(bookid)<br>

alter table cart<br>
add foreign key (id)<br>
references userdb(id)<br>

alter table cart<br>
add foreign key (bookid)<br>
references book(bookid)<br>
cart테이블의 id는 userdb id와 일치해야 함<br>

cart.java id추가<br>
cartDAO.java<br>
cart.jsp구현<br>
login.jsp수정<br>
guest_top.jsp 경로 수정<br>

<br><br>문제점<br>
회원가입하고 로그인 안됨<br>
addbook과 register차이점?<br>
addbook.jsp동작안함<br>
