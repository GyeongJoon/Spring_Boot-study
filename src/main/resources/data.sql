INSERT INTO article(title, content) VALUES('소주', '새로');
INSERT INTO article(title, content) VALUES('맥주', '테라');
INSERT INTO article(title, content) VALUES('막걸리', '장수막걸리');
-- article 테이블에 데이터 추가
INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글 고');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글 ㄱ');
INSERT INTO article(title, content) VALUES('당신의 취미는?', '댓글 go');
-- 4번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(4, '짱준', '어바웃 타임');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '짱구', '짱구는 못말려 극장판');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '짱아', '코코');
-- 5번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(5, '짱준', '고기');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '짱구', '초코비');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '짱아', '이유식');
-- 6번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(6, '짱준', '코딩');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '짱구', '부리부리');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '짱아', '독서');






INSERT INTO member(id, email, password) VALUES(1, 'jjangjoon328@naver.com', '123');
INSERT INTO member(id, email, password) VALUES(2, 'jjanggu@naver.com', '456');
INSERT INTO member(id, email, password) VALUES(3, 'jjangah@naver.com', '789');

INSERT INTO coffee(name, price) VALUES ('아메리카노', '4000');
INSERT INTO coffee(name, price) VALUES ('카페 라떼', '4500');
INSERT INTO coffee(name, price) VALUES ('북숭아 아이스티', '5000');