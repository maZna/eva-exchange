INSERT INTO share (share_id, share_code) VALUES (25323, 'SFJ');
INSERT INTO share (share_id, share_code) VALUES (25533, 'ACQ');
INSERT INTO share (share_id, share_code) VALUES (25623, 'VQC');
INSERT INTO share (share_id, share_code) VALUES (25821, 'QKM');
INSERT INTO share (share_id, share_code) VALUES (26023, 'BHF');

INSERT INTO user_portfolio (portfolio_id, portfolio_user_address, portfolio_user_dob, portfolio_user_name, portfolio_user_occupation) VALUES ('13432', 'Istanbul, Turkey', '1990-08-21 00:00:00', 'Masna Ahmed', 'Software Developer');
INSERT INTO user_portfolio (portfolio_id, portfolio_user_address, portfolio_user_dob, portfolio_user_name, portfolio_user_occupation) VALUES ('13452', 'Bursa, Turkey', '1988-09-05 00:00:00', 'Cem Tekin', 'Government Officer');
INSERT INTO user_portfolio (portfolio_id, portfolio_user_address, portfolio_user_dob, portfolio_user_name, portfolio_user_occupation) VALUES ('13524', 'Antalya, Turkey', '1981-01-13 00:00:00', 'Umut Hasan', 'Business Owner');
INSERT INTO user_portfolio (portfolio_id, portfolio_user_address, portfolio_user_dob, portfolio_user_name, portfolio_user_occupation) VALUES ('13622', 'Ankara, Turkey', '1995-03-27 00:00:00', 'Umair Ahmed', 'University Professor');
INSERT INTO user_portfolio (portfolio_id, portfolio_user_address, portfolio_user_dob, portfolio_user_name, portfolio_user_occupation) VALUES ('13679', 'Izmir, Turkey', '1990-08-21 00:00:00', 'Hakan Teker', 'Architect');

INSERT INTO share_price (update_id, share_currency, share_price, update_date, share_id) VALUES ('1234', 'USD', '25.21', '2021-08-20 00:00:00', 'SFJ');
INSERT INTO share_price (update_id, share_currency, share_price, update_date, share_id) VALUES ('1213', 'USD', '34.65', '2021-08-20 00:00:00', 'ACQ');
INSERT INTO share_price (update_id, share_currency, share_price, update_date, share_id) VALUES ('1245', 'USD', '45.12', '2021-08-20 00:00:00', 'VQC');
INSERT INTO share_price (update_id, share_currency, share_price, update_date, share_id) VALUES ('1266', 'USD', '8.42', '2021-08-20 00:00:00', 'QKM');
INSERT INTO share_price (update_id, share_currency, share_price, update_date, share_id) VALUES ('1297', 'USD', '55.08', '2021-08-20 00:00:00', 'BHF');

INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13432', '25533');
INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13432', '25623');
INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13432', '25821');
INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13432', '26023');

INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13452', '25323');

INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13524', '25623');

INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13679', '25533');
INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13679', '25623');
INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13679', '25821');

INSERT INTO user_shares (portfolio_id, share_id) VALUES ('13622', '25821');


INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('123', '2', 'BUY', 'ACQ', '1213', '13432');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('124', '3', 'SELL', 'SFJ', '1234', '13452');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('125', '2', 'BUY', 'VQC', '1245', '13432');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('126', '1', 'SELL', 'SFJ', '1234', '13452');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('127', '5', 'SELL', 'VQC', '1245', '13524');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('128', '3', 'BUY', 'ACQ', '1213', '13679');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('131', '6', 'BUY', 'QKM', '1266', '13622');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('134', '5', 'SELL', 'QKM', '1266', '13432');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('137', '7', 'BUY', 'VQC', '1245', '13679');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('145', '4', 'SELL', 'BHF', '1297', '13432');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('147', '1', 'SELL', 'BHF', '1297', '13432');
INSERT INTO share_transaction (transaction_id, number_of_shares, transaction_type, transaction_share, transaction_share_price, transaction_user) VALUES ('167', '6', 'BUY', 'QKM', '1266', '13679');
