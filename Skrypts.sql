CREATE TABLE erm_soun ( 
  code varchar(4), 
  shortName varchar(120), 
  fullName varchar(250) 
);

CREATE INDEX index_code
ON erm_soun (code)

INSERT INTO erm_soun VALUES 
(	0000	,	"	�������������� ������	"	,	"	��������������� ��������� ������ ���������� ���������	"	)	,
(	0000	,	"	��� ������	"	,	"	������������ ���������� ��������� �� ������� � ������	"	)	,
(	0000	,	"	��� ������	"	,	"	����������� ��������� ������	"	)	,
(	0001	,	"	���������.���� �� ������������ ���.������	"	,	"	��������������� ��������� ��� ������ �� ������������ ������������ ������	"	)	,
(	0001	,	"	���������.���� �� ������������ ���.������	"	,	"	��������������� ��������� ��� ������ �� ������������ ������������ ������	"	)	,
(	0002	,	"	���������.���� �� ������-��������� ���.������	"	,	"	��������������� ��������� ��� ������ �� ������-��������� ������������ ������	"	)	,
(	0002	,	"	���������.���� �� ������-��������� ���.������	"	,	"	��������������� ��������� ��� ������ �� ������-��������� ������������ ������	"	)	,
(	0003	,	"	���������.���� �� ������ ���.������	"	,	"	��������������� ��������� ��� ������ �� ������ ������������ ������	"	)	,

...

