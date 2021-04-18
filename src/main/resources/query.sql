-- 게시판 테이블 생성 쿼리
create table tb_board
(
    board_id   int auto_increment primary key,
    title      varchar(50),
    contents   varchar(2000),
    reg_date   datetime,
    board_type varchar(10)
);


-- 파일업로드 테이블 생성 쿼리
create table tb_upload_file
(
    file_seq          int auto_increment primary key,
    path_name         varchar(100)            not null,
    file_name         varchar(50)             not null,
    org_filename      varchar(100)            not null,
    size              int                     not null,
    content_type      varchar(50)             not null,
    resource_pathname varchar(100) default '' not null,
    reg_date          datetime                not null
);

